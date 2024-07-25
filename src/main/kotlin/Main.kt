import org.apache.beam.runners.direct.DirectRunner
import org.apache.beam.runners.flink.FlinkRunner
import org.apache.beam.sdk.Pipeline
import org.apache.beam.sdk.options.PipelineOptionsFactory
import org.apache.beam.sdk.transforms.Create
import org.apache.beam.sdk.transforms.DoFn
import org.apache.beam.sdk.transforms.ParDo
import org.apache.beam.sdk.transforms.join.CoGbkResult
import org.apache.beam.sdk.transforms.join.CoGroupByKey
import org.apache.beam.sdk.transforms.join.KeyedPCollectionTuple
import org.apache.beam.sdk.values.KV
import org.apache.beam.sdk.values.TupleTag

fun main(args: Array<String>) {
    val options = PipelineOptionsFactory.fromArgs(*args).create().apply {
        runner = FlinkRunner::class.java
//        runner = DirectRunner::class.java // Direct runner works fine
    }

    val pipeline = Pipeline.create(options)

    val startingCollection = pipeline.apply("start", Create.of(listOf(1)))

    val replicateElementFn = object: DoFn<Int, KV<Int, Int>>() {
        @ProcessElement  // Turns a PCollection of one element into 20K pairs, all with key=0
        fun processElement(context: ProcessContext) {
            (1..20000).forEach {
                context.output(KV.of(0, it))
            }
        }
    }

    // Create two collections of 20K KV pairs each
    val left = startingCollection.apply("replicate_left", ParDo.of(replicateElementFn))
    val right = startingCollection.apply("replicate_right", ParDo.of(replicateElementFn))

    // CoGBK the collections above
    val leftTag = object : TupleTag<Int>() {}
    val rightTag = object : TupleTag<Int>() {}
    val tuple = KeyedPCollectionTuple.of(leftTag, left).and(rightTag, right)

    tuple.apply("CoGBK", CoGroupByKey.create()).apply(
        "HandleCoGbk",
        ParDo.of(object: DoFn<KV<Int, CoGbkResult>, Int>() {
            @ProcessElement  // Turns a PCollection of one element into 20K pairs, all with key=0
            fun processElement(context: ProcessContext) {
                val leftValues = context.element().value.getAll(leftTag).toList()  // Should crash here
                val rightValues = context.element().value.getAll(rightTag).toList()
                context.output(leftValues.sum() + rightValues.sum())
            }
        })
    )

    pipeline.run()
}
