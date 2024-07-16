# SqlDelight 2.1.x Postgresql Aggregate Expressions 

https://github.com/cashapp/sqldelight

Snapshot version: 2.1.0-SNAPSHOT

Support aggregate expressions

functions supported `string_agg`, `array_agg`

```sql
SELECT Articles.id, Articles.slug, Articles.title, Articles.description,
COALESCE (string_agg (DISTINCT Tags.tag, ',' ORDER BY Tags.tag DESC)
FILTER (WHERE Tags.tag IS NOT NULL)) AS articleTags
FROM Articles
LEFT JOIN Tags ON Articles.id = Tags.article_id
JOIN Authors ON Articles.author_id = Authors.id
GROUP BY Articles.id, Authors.id;
```
----

* Support `FILTER/WHERE` and `ORDER BY`
  * MERGED https://github.com/cashapp/sqldelight/pull/5071

```shell
createdb aggregates &&
./gradlew build &&
./gradlew flywayMigrate
```

Flyway db migrations
https://documentation.red-gate.com/fd/gradle-task-184127407.html
