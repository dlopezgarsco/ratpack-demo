package com.dlopez.ratpack.handlers

import ratpack.handling.Context
import ratpack.handling.Handler

class BarHandler : Handler {
  override fun handle(context: Context) {
    context.response.send("YOU JUST HIT A BAR CHILD!")
  }
}
