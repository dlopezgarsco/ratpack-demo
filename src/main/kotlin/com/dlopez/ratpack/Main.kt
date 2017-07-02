package com.dlopez.ratpack

import com.dlopez.ratpack.handlers.CORSHandler
import com.dlopez.ratpack.handlers.Router
import ratpack.server.RatpackServer


class Main {
  companion object {
    @JvmStatic fun main(args: Array<String>) {
      RatpackServer.start { server ->
        server
            .handlers { chain ->
              chain
                  .all(CORSHandler())
                  .all(Router())
                  .prefix("api", { ctx ->
                    ctx.get { it.render("Entering API!") }
                    ctx.get("foo", {
                      it.render("this is foo!")
                    })
                    ctx.get("bar", {
                      it.render("this is bar!")
                    })
                  })

            }
            .serverConfig { config ->
              config
                  .port(5000)
                  .development(true)
                  .sysProps()
            }
      }
    }
  }
}