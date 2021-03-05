package com.common.config

import com.common.config.ConfigLoader.conf
import com.typesafe.config.Config

//An example set of headers for all requests
object HeaderParams {
  val headersConf: Config = conf.getConfig("headers")
  val userAgent = "User-Agent"
  val accept = "Accept"
  val acceptLanguage = "Accept-Language"
  val contentType = "Content-Type"
  val requestWith = "X-Requested-With"
  val encoding = "Accept-Encoding"

  val sentHeaders: Map[String, String] = Map(
    userAgent -> headersConf.getString(userAgent),
    accept -> headersConf.getString(accept),
    acceptLanguage -> headersConf.getString(acceptLanguage),
    contentType -> headersConf.getString(contentType),
    requestWith -> headersConf.getString(requestWith),
    encoding -> headersConf.getString(encoding)
  )
}
