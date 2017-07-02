package com.dlopez.ratpack.handlers

import ratpack.handling.Context
import ratpack.handling.Handler

class CORSHandler: Handler {
  override fun handle(ctx: Context) {
    ctx.response.headers.apply {
      set("Access-Control-Allow-Origin", "*")
      set("Access-Control-Allow-Headers", "x-requested-with, origin, content-type, accept")
    }
    ctx.next()
  }

}