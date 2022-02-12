package df.cli

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.prompt
import com.github.ajalt.clikt.parameters.types.choice
import kotlinx.coroutines.runBlocking


class ParseAndRun : CliktCommand() {
    val operation by option()
        .choice(
            *CommandOptions.values().map { it.toString().lowercase() }.toTypedArray()
        ).prompt("Choose an operation [export, restore, update]")

    override fun run() {
        echo("running $operation starting now!")
        runBlocking {
            val app = App()
            app(CommandOptions.valueOf(operation.uppercase()))
        }
    }
}
