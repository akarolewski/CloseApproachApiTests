package com.common.config

import HeaderParams.sentHeaders
import com.common.config.ConfigLoader.conf
import io.gatling.core.Predef.configuration
import io.gatling.http.Predef.http
import io.gatling.http.protocol.HttpProtocolBuilder

//A Scala Object responsible for setting up application url and headers configuration
object Configuration {
  val appUrl: String = conf.getString("url")
  val urlConfig: HttpProtocolBuilder = http.baseUrl(appUrl)
  val httpConfig: HttpProtocolBuilder = urlConfig.headers(sentHeaders)
}
