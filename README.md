Run `./gradlew run` to reproduce the issue.

```
❯ ./gradlew run

> Task :run
SLF4J: No SLF4J providers were found.
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See https://www.slf4j.org/codes.html#noProviders for further details.
Exception in thread "main" java.lang.RuntimeException: Pipeline execution failed
        at org.apache.beam.runners.flink.FlinkRunner.run(FlinkRunner.java:107)
        at org.apache.beam.sdk.Pipeline.run(Pipeline.java:325)
        at org.apache.beam.sdk.Pipeline.run(Pipeline.java:310)
        at MainKt.main(Main.kt:54)
Caused by: org.apache.flink.runtime.client.JobExecutionException: Job execution failed.
        at org.apache.flink.runtime.jobmaster.JobResult.toJobExecutionResult(JobResult.java:144)
        at org.apache.flink.runtime.minicluster.MiniClusterJobClient.lambda$getJobExecutionResult$3(MiniClusterJobClient.java:141)
        at java.base/java.util.concurrent.CompletableFuture$UniApply.tryFire(CompletableFuture.java:646)
        at java.base/java.util.concurrent.CompletableFuture.postComplete(CompletableFuture.java:510)
        at java.base/java.util.concurrent.CompletableFuture.complete(CompletableFuture.java:2179)
        at org.apache.flink.runtime.rpc.pekko.PekkoInvocationHandler.lambda$invokeRpc$1(PekkoInvocationHandler.java:268)
        at java.base/java.util.concurrent.CompletableFuture.uniWhenComplete(CompletableFuture.java:863)
        at java.base/java.util.concurrent.CompletableFuture$UniWhenComplete.tryFire(CompletableFuture.java:841)
        at java.base/java.util.concurrent.CompletableFuture.postComplete(CompletableFuture.java:510)
        at java.base/java.util.concurrent.CompletableFuture.complete(CompletableFuture.java:2179)
        at org.apache.flink.util.concurrent.FutureUtils.doForward(FutureUtils.java:1267)
        at org.apache.flink.runtime.concurrent.ClassLoadingUtils.lambda$null$1(ClassLoadingUtils.java:93)
        at org.apache.flink.runtime.concurrent.ClassLoadingUtils.runWithContextClassLoader(ClassLoadingUtils.java:68)
        at org.apache.flink.runtime.concurrent.ClassLoadingUtils.lambda$guardCompletionWithContextClassLoader$2(ClassLoadingUtils.java:92)
        at java.base/java.util.concurrent.CompletableFuture.uniWhenComplete(CompletableFuture.java:863)
        at java.base/java.util.concurrent.CompletableFuture$UniWhenComplete.tryFire(CompletableFuture.java:841)
        at java.base/java.util.concurrent.CompletableFuture.postComplete(CompletableFuture.java:510)
        at java.base/java.util.concurrent.CompletableFuture.complete(CompletableFuture.java:2179)
        at org.apache.flink.runtime.concurrent.pekko.ScalaFutureUtils$1.onComplete(ScalaFutureUtils.java:47)
        at org.apache.pekko.dispatch.OnComplete.internal(Future.scala:310)
        at org.apache.pekko.dispatch.OnComplete.internal(Future.scala:307)
        at org.apache.pekko.dispatch.japi$CallbackBridge.apply(Future.scala:234)
        at org.apache.pekko.dispatch.japi$CallbackBridge.apply(Future.scala:231)
        at scala.concurrent.impl.CallbackRunnable.run(Promise.scala:64)
        at org.apache.flink.runtime.concurrent.pekko.ScalaFutureUtils$DirectExecutionContext.execute(ScalaFutureUtils.java:65)
        at scala.concurrent.impl.CallbackRunnable.executeWithValue(Promise.scala:72)
        at scala.concurrent.impl.Promise$DefaultPromise.$anonfun$tryComplete$1(Promise.scala:288)
        at scala.concurrent.impl.Promise$DefaultPromise.$anonfun$tryComplete$1$adapted(Promise.scala:288)
        at scala.concurrent.impl.Promise$DefaultPromise.tryComplete(Promise.scala:288)
        at org.apache.pekko.pattern.PromiseActorRef.$bang(AskSupport.scala:629)
        at org.apache.pekko.pattern.PipeToSupport$PipeableFuture$$anonfun$pipeTo$1.applyOrElse(PipeToSupport.scala:34)
        at org.apache.pekko.pattern.PipeToSupport$PipeableFuture$$anonfun$pipeTo$1.applyOrElse(PipeToSupport.scala:33)
        at scala.concurrent.Future.$anonfun$andThen$1(Future.scala:536)
        at scala.concurrent.impl.Promise.liftedTree1$1(Promise.scala:33)
        at scala.concurrent.impl.Promise.$anonfun$transform$1(Promise.scala:33)
        at scala.concurrent.impl.CallbackRunnable.run(Promise.scala:64)
        at org.apache.pekko.dispatch.BatchingExecutor$AbstractBatch.processBatch(BatchingExecutor.scala:73)
        at org.apache.pekko.dispatch.BatchingExecutor$BlockableBatch.$anonfun$run$1(BatchingExecutor.scala:110)
        at scala.runtime.java8.JFunction0$mcV$sp.apply(JFunction0$mcV$sp.java:23)
        at scala.concurrent.BlockContext$.withBlockContext(BlockContext.scala:85)
        at org.apache.pekko.dispatch.BatchingExecutor$BlockableBatch.run(BatchingExecutor.scala:110)
        at org.apache.pekko.dispatch.TaskInvocation.run(AbstractDispatcher.scala:59)
        at org.apache.pekko.dispatch.ForkJoinExecutorConfigurator$PekkoForkJoinTask.exec(ForkJoinExecutorConfigurator.scala:57)
        at java.base/java.util.concurrent.ForkJoinTask.doExec(ForkJoinTask.java:387)
        at java.base/java.util.concurrent.ForkJoinPool$WorkQueue.topLevelExec(ForkJoinPool.java:1312)
        at java.base/java.util.concurrent.ForkJoinPool.scan(ForkJoinPool.java:1843)
        at java.base/java.util.concurrent.ForkJoinPool.runWorker(ForkJoinPool.java:1808)
        at java.base/java.util.concurrent.ForkJoinWorkerThread.run(ForkJoinWorkerThread.java:188)
Caused by: org.apache.flink.runtime.JobException: Recovery is suppressed by NoRestartBackoffTimeStrategy
        at org.apache.flink.runtime.executiongraph.failover.flip1.ExecutionFailureHandler.handleFailure(ExecutionFailureHandler.java:176)
        at org.apache.flink.runtime.executiongraph.failover.flip1.ExecutionFailureHandler.getFailureHandlingResult(ExecutionFailureHandler.java:107)
        at org.apache.flink.runtime.scheduler.DefaultScheduler.recordTaskFailure(DefaultScheduler.java:285)
        at org.apache.flink.runtime.scheduler.DefaultScheduler.handleTaskFailure(DefaultScheduler.java:276)
        at org.apache.flink.runtime.scheduler.DefaultScheduler.onTaskFailed(DefaultScheduler.java:269)
        at org.apache.flink.runtime.scheduler.SchedulerBase.onTaskExecutionStateUpdate(SchedulerBase.java:764)
        at org.apache.flink.runtime.scheduler.SchedulerBase.updateTaskExecutionState(SchedulerBase.java:741)
        at org.apache.flink.runtime.scheduler.SchedulerNG.updateTaskExecutionState(SchedulerNG.java:83)
        at org.apache.flink.runtime.jobmaster.JobMaster.updateTaskExecutionState(JobMaster.java:488)
        at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)
        at java.base/java.lang.reflect.Method.invoke(Method.java:580)
        at org.apache.flink.runtime.rpc.pekko.PekkoRpcActor.lambda$handleRpcInvocation$1(PekkoRpcActor.java:309)
        at org.apache.flink.runtime.concurrent.ClassLoadingUtils.runWithContextClassLoader(ClassLoadingUtils.java:83)
        at org.apache.flink.runtime.rpc.pekko.PekkoRpcActor.handleRpcInvocation(PekkoRpcActor.java:307)
        at org.apache.flink.runtime.rpc.pekko.PekkoRpcActor.handleRpcMessage(PekkoRpcActor.java:222)
        at org.apache.flink.runtime.rpc.pekko.FencedPekkoRpcActor.handleRpcMessage(FencedPekkoRpcActor.java:85)
        at org.apache.flink.runtime.rpc.pekko.PekkoRpcActor.handleMessage(PekkoRpcActor.java:168)
        at org.apache.pekko.japi.pf.UnitCaseStatement.apply(CaseStatements.scala:33)
        at org.apache.pekko.japi.pf.UnitCaseStatement.apply(CaseStatements.scala:29)
        at scala.PartialFunction.applyOrElse(PartialFunction.scala:127)
        at scala.PartialFunction.applyOrElse$(PartialFunction.scala:126)
        at org.apache.pekko.japi.pf.UnitCaseStatement.applyOrElse(CaseStatements.scala:29)
        at scala.PartialFunction$OrElse.applyOrElse(PartialFunction.scala:175)
        at scala.PartialFunction$OrElse.applyOrElse(PartialFunction.scala:176)
        at scala.PartialFunction$OrElse.applyOrElse(PartialFunction.scala:176)
        at org.apache.pekko.actor.Actor.aroundReceive(Actor.scala:547)
        at org.apache.pekko.actor.Actor.aroundReceive$(Actor.scala:545)
        at org.apache.pekko.actor.AbstractActor.aroundReceive(AbstractActor.scala:229)
        at org.apache.pekko.actor.ActorCell.receiveMessage(ActorCell.scala:590)
        at org.apache.pekko.actor.ActorCell.invoke(ActorCell.scala:557)
        at org.apache.pekko.dispatch.Mailbox.processMailbox(Mailbox.scala:280)
        at org.apache.pekko.dispatch.Mailbox.run(Mailbox.scala:241)
        at org.apache.pekko.dispatch.Mailbox.exec(Mailbox.scala:253)
        ... 5 more
Caused by: org.apache.beam.sdk.util.UserCodeException: org.apache.flink.runtime.operators.chaining.ExceptionInChainedStubException: Exception in chained task 'FlatMap (FlatMap at CoGBK/ConstructCoGbkResultFn/ParMultiDo(ConstructCoGbkResult).output)'
        at org.apache.beam.sdk.util.UserCodeException.wrap(UserCodeException.java:39)
        at org.apache.beam.sdk.transforms.join.CoGroupByKey$ConstructCoGbkResultFn$DoFnInvoker.invokeProcessElement(Unknown Source)
        at org.apache.beam.runners.core.SimpleDoFnRunner.invokeProcessElement(SimpleDoFnRunner.java:212)
        at org.apache.beam.runners.core.SimpleDoFnRunner.processElement(SimpleDoFnRunner.java:189)
        at org.apache.beam.runners.flink.metrics.DoFnRunnerWithMetricsUpdate.processElement(DoFnRunnerWithMetricsUpdate.java:62)
        at org.apache.beam.runners.flink.translation.functions.FlinkDoFnFunction.flatMap(FlinkDoFnFunction.java:122)
        at org.apache.beam.runners.flink.translation.functions.FlinkDoFnFunction.flatMap(FlinkDoFnFunction.java:59)
        at org.apache.flink.runtime.operators.chaining.ChainedFlatMapDriver.collect(ChainedFlatMapDriver.java:79)
        at org.apache.flink.runtime.operators.util.metrics.CountingCollector.collect(CountingCollector.java:35)
        at org.apache.beam.runners.flink.translation.functions.FlinkNonMergingReduceFunction.reduce(FlinkNonMergingReduceFunction.java:103)
        at org.apache.flink.api.java.operators.translation.PlanUnwrappingReduceGroupOperator$TupleUnwrappingNonCombinableGroupReducer.reduce(PlanUnwrappingReduceGroupOperator.java:120)
        at org.apache.flink.runtime.operators.GroupReduceDriver.run(GroupReduceDriver.java:145)
        at org.apache.flink.runtime.operators.BatchTask.run(BatchTask.java:514)
        at org.apache.flink.runtime.operators.BatchTask.invoke(BatchTask.java:357)
        at org.apache.flink.runtime.taskmanager.Task.runWithSystemExitMonitoring(Task.java:953)
        at org.apache.flink.runtime.taskmanager.Task.restoreAndInvoke(Task.java:932)
        at org.apache.flink.runtime.taskmanager.Task.doRun(Task.java:746)
        at org.apache.flink.runtime.taskmanager.Task.run(Task.java:562)
        at java.base/java.lang.Thread.run(Thread.java:1583)
Caused by: org.apache.flink.runtime.operators.chaining.ExceptionInChainedStubException: Exception in chained task 'FlatMap (FlatMap at CoGBK/ConstructCoGbkResultFn/ParMultiDo(ConstructCoGbkResult).output)'
        at org.apache.flink.runtime.operators.chaining.ChainedFlatMapDriver.collect(ChainedFlatMapDriver.java:81)
        at org.apache.flink.runtime.operators.util.metrics.CountingCollector.collect(CountingCollector.java:35)
        at org.apache.beam.runners.flink.translation.functions.FlinkDoFnFunction$DoFnOutputManager.output(FlinkDoFnFunction.java:221)
        at org.apache.beam.runners.core.SimpleDoFnRunner.outputWindowedValue(SimpleDoFnRunner.java:276)
        at org.apache.beam.runners.core.SimpleDoFnRunner.access$900(SimpleDoFnRunner.java:86)
        at org.apache.beam.runners.core.SimpleDoFnRunner$DoFnProcessContext.output(SimpleDoFnRunner.java:432)
        at org.apache.beam.runners.core.SimpleDoFnRunner$DoFnProcessContext.output(SimpleDoFnRunner.java:412)
        at org.apache.beam.sdk.transforms.join.CoGroupByKey$ConstructCoGbkResultFn.processElement(CoGroupByKey.java:192)
Caused by: org.apache.beam.sdk.util.UserCodeException: java.lang.IllegalStateException: GBK result is not re-iterable. You can enable re-iterations by setting '--reIterableGroupByKeyResult'.
        at org.apache.beam.sdk.util.UserCodeException.wrap(UserCodeException.java:39)
        at MainKt$main$1$DoFnInvoker.invokeProcessElement(Unknown Source)
        at org.apache.beam.runners.core.SimpleDoFnRunner.invokeProcessElement(SimpleDoFnRunner.java:212)
        at org.apache.beam.runners.core.SimpleDoFnRunner.processElement(SimpleDoFnRunner.java:189)
        at org.apache.beam.runners.flink.metrics.DoFnRunnerWithMetricsUpdate.processElement(DoFnRunnerWithMetricsUpdate.java:62)
        at org.apache.beam.runners.flink.translation.functions.FlinkDoFnFunction.flatMap(FlinkDoFnFunction.java:122)
        at org.apache.beam.runners.flink.translation.functions.FlinkDoFnFunction.flatMap(FlinkDoFnFunction.java:59)
        at org.apache.flink.runtime.operators.chaining.ChainedFlatMapDriver.collect(ChainedFlatMapDriver.java:79)
        at org.apache.flink.runtime.operators.util.metrics.CountingCollector.collect(CountingCollector.java:35)
        at org.apache.beam.runners.flink.translation.functions.FlinkMultiOutputPruningFunction.flatMap(FlinkMultiOutputPruningFunction.java:60)
        at org.apache.beam.runners.flink.translation.functions.FlinkMultiOutputPruningFunction.flatMap(FlinkMultiOutputPruningFunction.java:35)
        at org.apache.flink.runtime.operators.chaining.ChainedFlatMapDriver.collect(ChainedFlatMapDriver.java:79)
        at org.apache.flink.runtime.operators.util.metrics.CountingCollector.collect(CountingCollector.java:35)
        at org.apache.beam.runners.flink.translation.functions.FlinkDoFnFunction$DoFnOutputManager.output(FlinkDoFnFunction.java:221)
        at org.apache.beam.runners.core.SimpleDoFnRunner.outputWindowedValue(SimpleDoFnRunner.java:276)
        at org.apache.beam.runners.core.SimpleDoFnRunner.access$900(SimpleDoFnRunner.java:86)
        at org.apache.beam.runners.core.SimpleDoFnRunner$DoFnProcessContext.output(SimpleDoFnRunner.java:432)
        at org.apache.beam.runners.core.SimpleDoFnRunner$DoFnProcessContext.output(SimpleDoFnRunner.java:412)
        at org.apache.beam.sdk.transforms.join.CoGroupByKey$ConstructCoGbkResultFn.processElement(CoGroupByKey.java:192)
        at org.apache.beam.sdk.transforms.join.CoGroupByKey$ConstructCoGbkResultFn$DoFnInvoker.invokeProcessElement(Unknown Source)
        at org.apache.beam.runners.core.SimpleDoFnRunner.invokeProcessElement(SimpleDoFnRunner.java:212)
        at org.apache.beam.runners.core.SimpleDoFnRunner.processElement(SimpleDoFnRunner.java:189)
        at org.apache.beam.runners.flink.metrics.DoFnRunnerWithMetricsUpdate.processElement(DoFnRunnerWithMetricsUpdate.java:62)
        at org.apache.beam.runners.flink.translation.functions.FlinkDoFnFunction.flatMap(FlinkDoFnFunction.java:122)
        at org.apache.beam.runners.flink.translation.functions.FlinkDoFnFunction.flatMap(FlinkDoFnFunction.java:59)
        at org.apache.flink.runtime.operators.chaining.ChainedFlatMapDriver.collect(ChainedFlatMapDriver.java:79)
        at org.apache.flink.runtime.operators.util.metrics.CountingCollector.collect(CountingCollector.java:35)
        at org.apache.beam.runners.flink.translation.functions.FlinkNonMergingReduceFunction.reduce(FlinkNonMergingReduceFunction.java:103)
        at org.apache.flink.api.java.operators.translation.PlanUnwrappingReduceGroupOperator$TupleUnwrappingNonCombinableGroupReducer.reduce(PlanUnwrappingReduceGroupOperator.java:120)
        at org.apache.flink.runtime.operators.GroupReduceDriver.run(GroupReduceDriver.java:145)
        at org.apache.flink.runtime.operators.BatchTask.run(BatchTask.java:514)
        at org.apache.flink.runtime.operators.BatchTask.invoke(BatchTask.java:357)
        at org.apache.flink.runtime.taskmanager.Task.runWithSystemExitMonitoring(Task.java:953)
        at org.apache.flink.runtime.taskmanager.Task.restoreAndInvoke(Task.java:932)
        at org.apache.flink.runtime.taskmanager.Task.doRun(Task.java:746)
        at org.apache.flink.runtime.taskmanager.Task.run(Task.java:562)
        at java.base/java.lang.Thread.run(Thread.java:1583)
Caused by: java.lang.IllegalStateException: GBK result is not re-iterable. You can enable re-iterations by setting '--reIterableGroupByKeyResult'.
        at org.apache.beam.runners.flink.translation.functions.FlinkNonMergingReduceFunction$OnceIterable.iterator(FlinkNonMergingReduceFunction.java:64)
        at org.apache.beam.sdk.transforms.join.CoGbkResult$RecordingFilteringIterator.<init>(CoGbkResult.java:801)
        at org.apache.beam.sdk.transforms.join.CoGbkResult.lambda$recordingFilteringIterable$2(CoGbkResult.java:758)
        at kotlin.collections.CollectionsKt___CollectionsKt.toCollection(_Collections.kt:1295)
        at kotlin.collections.CollectionsKt___CollectionsKt.toMutableList(_Collections.kt:1328)
        at kotlin.collections.CollectionsKt___CollectionsKt.toList(_Collections.kt:1319)
        at MainKt$main$1.processElement(Main.kt:47)
```