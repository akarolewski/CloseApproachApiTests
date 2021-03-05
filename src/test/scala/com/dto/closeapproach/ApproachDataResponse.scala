package com.dto.closeapproach

import play.api.libs.json.{Json, Reads}

//Example JSON schema for Approach Data Api response
case class ApproachDataResponse(
  signature: Signature,
  count: String,
  fields: Array[String],
  data: Seq[Array[String]]
)

object ApproachDataResponse {
  implicit val reads: Reads[ApproachDataResponse] = Json.reads[ApproachDataResponse]
}
