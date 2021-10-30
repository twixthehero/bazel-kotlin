package com.krythera.example

import org.apache.commons.cli.DefaultParser
import org.apache.commons.cli.HelpFormatter
import org.apache.commons.cli.Options
import kotlin.system.exitProcess

private const val optHelpShort = "h"
private const val optHelpLong = "help"
private const val optRespectShort = "f"
private const val optRespectLong = "respect"

fun main(args: Array<String>) {
    val opts = Options().apply {
        addOption(optHelpShort, optHelpLong, false, "Display this help.")
        addOption(optRespectShort, optRespectLong, false, "To pay respects.")
    }

    val cmd = DefaultParser().parse(opts, args)

    if (cmd.hasOption(optHelpShort)) {
        HelpFormatter().printHelp("bazel run //example --", "\nRun the Bazel Kotlin example", opts, "", true)
        exitProcess(1)
    }

    if (cmd.hasOption(optRespectShort)) {
        println("Respects paid.")
    } else {
        println("Respects not paid.")
    }
}
