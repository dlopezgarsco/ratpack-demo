package com.dlopez.ratpack

import com.dlopez.ratpack.handlers.CORSHandler
import ratpack.handling.Chain
import ratpack.handling.Context
import ratpack.server.RatpackServer
import ratpack.server.RatpackServerSpec
import ratpack.server.ServerConfigBuilder

object Main {

  @JvmStatic fun main(args: Array<String>) {
    RatpackServer.start { server: RatpackServerSpec ->
      server
          .handlers { chain: Chain ->
            chain
                .all(CORSHandler())
                .prefix("api", Main::apiChain)
          }
          .serverConfig { config: ServerConfigBuilder ->
            config
                .port(5000)
                .development(true)
                .sysProps()
          }
    }
  }

  private fun fooHandler(context: Context) = context.render("fooHandler!")

  private fun barHandler(context: Context) = context.render("barHandler!")

  private fun apiChain(api: Chain) {
    with(api) {
      get { it.render("Entering /api") }
      get("foo", Main::fooHandler)
      get("bar", Main::barHandler)
    }
  }
}

