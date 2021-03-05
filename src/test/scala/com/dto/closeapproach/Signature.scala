package com.dto.closeapproach

import play.api.libs.json.{Json, Reads}

case class Signature(
  source: String,
  version: String
)

object Signature {
  implicit val reads: Reads[Signature] = Json.reads[Signature]
}
