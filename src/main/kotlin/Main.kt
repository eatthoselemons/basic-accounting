import com.fasterxml.jackson.dataformat.csv.CsvMapper
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.subcommands
import com.github.ajalt.clikt.parameters.arguments.argument
import org.jetbrains.exposed.sql.*

data class Transaction(
    val name: String,
    val value: Int
)

class DBTrait {
    val database by lazy {
        Database.connect(
            url = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1",
            user = "root",
            driver = "org.h2.Driver",
            password = "",
        )
    }
}

class Main : CliktCommand(help = "CSV and SQL tool") {
    override fun run() {}
}

class Load : CliktCommand() {

    val query by argument("query", help = "An sql query to execute")

    override fun run() {
        val mapper = CsvMapper()
        val schema = mapper.schemaFor(Transaction::class.java)
    }
}

class Query : CliktCommand() {
    override fun run() {}
}

fun main(args: Array<String>) = Main().subcommands(Load(), Query()).main(args)
