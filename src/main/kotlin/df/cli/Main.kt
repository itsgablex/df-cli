#!/usr/bin/env kscript

@file:MavenRepository("libraries-bom", "https://repo.maven.apache.org/maven2/com/google/cloud/libraries-bom/23.0.0")
@file:MavenRepository("kotlin-bom", "https://repo.maven.apache.org/maven2/org/jetbrains/kotlin/kotlin-bom/1.6.10")

@file:DependsOn("com.google.cloud:google-cloud-dialogflow:4.4.0")
@file:DependsOn("com.github.holgerbrandl:kscript-annotations:1.2")
@file:DependsOn("org.jetbrains.kotlin:kotlin-stdlib:1.6.10")
@file:DependsOn("org.jetbrains.kotlin:kotlin-scripting-common:1.6.10")
@file:DependsOn("org.jetbrains.kotlin:kotlin-scripting-jvm:1.6.10")
@file:DependsOn("org.jetbrains.kotlin:kotlin-scripting-jvm-host-embeddable:1.3.72")
@file:DependsOn("org.jetbrains.kotlin:kotlin-scripting-dependencies:1.6.10")

@file:DependsOn("com.github.vladimir-bukhtoyarov:bucket4j-core:7.1.0")

@file:DependsOn("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
@file:DependsOn("org.jetbrains.kotlinx:kotlinx-cli:0.3.4")
@file:Include("CliRunner.kt")

@file:DependsOn("com.github.ajalt.clikt:clikt-jvm:3.4.0")

@file:Include("App.kt")
@file:Include("CommandOptions.kt")

@file:KotlinOpts("-J-Xmx5g")
@file:KotlinOpts("-J-server")
@file:CompilerOpts("-jvm-target 11")
@file:CompilerOpts("-Xopt-in=kotlin.time.ExperimentalTime")
@file:CompilerOpts("-opt-in=kotlin.RequiresOptIn")
@file:KotlinOpts("-Xopt-in=kotlinx.cli.ExperimentalCli")

package df.cli


import CompilerOpts
import Include
import KotlinOpts
import MavenRepository
import kotlinx.coroutines.runBlocking
import kotlin.script.experimental.dependencies.DependsOn


fun main(args: Array<String>) = runBlocking {
    ParseAndRun().main(args)
}