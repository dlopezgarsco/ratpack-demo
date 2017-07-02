package com.dlopez.ratpack.handlers

import ratpack.handling.Context
import ratpack.handling.Handler

class FooHandler : Handler {
  override fun handle(context: Context) {
    context.response.send("YOU JUST HIT A FOO CHILD!")
  }
}
