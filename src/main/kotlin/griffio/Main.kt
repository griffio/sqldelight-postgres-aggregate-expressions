package griffio

import app.cash.sqldelight.driver.jdbc.asJdbcDriver
import griffio.queries.Sample
import org.postgresql.ds.PGSimpleDataSource

private fun getSqlDriver() = PGSimpleDataSource().apply {
    setURL("jdbc:postgresql://localhost:5432/aggregates")
    applicationName = "App Main"
}.asJdbcDriver()

fun main() {
    val driver = getSqlDriver()
    val sample = Sample(driver)
    println(sample.articlesQueries.getArticlesWithAuthor().executeAsList().joinToString("\n"))
    println(sample.articlesQueries.getArticles().executeAsList().joinToString("\n"))
}
