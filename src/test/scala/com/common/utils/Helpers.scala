package com.common.utils

import com.common.http.Status.OK
import com.typesafe.scalalogging.Logger
import io.gatling.core.Predef._
import io.gatling.core.check.ValidatorCheckBuilder
import io.gatling.core.check.extractor.string.BodyStringCheckType
import io.gatling.http.Predef._
import io.gatling.http.check.HttpCheck
import play.api.libs.json.{JsError, JsSuccess, Json, Reads}

import scala.util.Random
import scala.util.Random.nextInt

//Example Scala Object with some universal methods to assert expected statuses or validate response JSON schema etc
object Helpers {

  private val logger = Logger("Validation Errors")

  def isValidStatus(httpStatus: Seq[Int]): HttpCheck = status.in(httpStatus)

  def isValidStatus(httpStatus: Int): HttpCheck = status.is(httpStatus)

  def responseValidation(check: HttpCheck): HttpCheck =
    checkIf[Response, HttpCheck]((r: Response, _: Session) => r.status.code.equals(OK)) {
      check
    }

  def validateJSONBody[T: Reads]: ValidatorCheckBuilder[BodyStringCheckType, String, Boolean] =
    bodyString.transform { (json, _) =>
      Json.parse(json).validate[T] match {
        case JsSuccess(_, _) => true
        case JsError(errors) =>
          logger.error(errors.toString)
          false
      }
    }

  def validateSchema[T: Reads] = validateJSONBody.is(true)

  def randomAlphaNumericString(n: Int): String = Random.alphanumeric.take(n).mkString

  def randomNumeric(n: Int): String = Stream.continually(nextInt(9)).take(n).mkString

}
