package com.dlopez.ratpack.handlers

import org.skife.jdbi.v2.DBI

class DBHandler {
  init {
    val h = DBI("jdbc:h2:mem:test").open()
    h.execute(
        "CREATE TABLE USER(id int primary key, name varchar(100))"
    )
    h.execute(
        "INSERT INTO USER (id, name) VALUES (?, ?)", 3, "Patrick"
    )
    val rs: List<MutableMap<String, Any>> = h.select("select id, name from something")
    print(rs.size)
  }
}