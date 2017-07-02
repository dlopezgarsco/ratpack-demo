package com.dlopez.ratpack.handlers

import ratpack.handling.Context
import ratpack.handling.Handler

class Router : Handler {

  override fun handle(ctx: Context) {
    with(ctx.request.path) {
      when {
        equals("foo") -> ctx.render("EXACT FOO")
        startsWith("foo") -> ctx.insert(FooHandler())
        startsWith("bar") -> ctx.insert(BarHandler())
        else -> ctx.next() // ?
      }
    }
  }
}