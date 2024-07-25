plugins {
    kotlin("jvm") version "1.9.25"
    id("org.jetbrains.kotlin.kapt") version "1.9.25"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val apacheBeamVersion = "2.57.0"


dependencies {
    kapt("org.apache.beam:beam-sdks-java-core:$apacheBeamVersion")
    implementation("org.apache.beam:beam-sdks-java-core:$apacheBeamVersion")
    implementation("org.apache.beam:beam-sdks-java-io-amazon-web-services2:$apacheBeamVersion")
    implementation("org.apache.beam:beam-runners-direct-java:$apacheBeamVersion")
    implementation("org.apache.beam:beam-runners-flink-1.18:$apacheBeamVersion")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("MainKt")
}

kotlin {
    jvmToolchain(21)
}