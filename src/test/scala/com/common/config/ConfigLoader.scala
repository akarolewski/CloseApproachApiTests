package com.common.config

import com.typesafe.config.{Config, ConfigFactory}

//A Scala object responsible for fetching config file
object ConfigLoader {
  val conf: Config = ConfigFactory.load()
}
