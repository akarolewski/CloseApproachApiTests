package com.scenarios

import com.common.enums.FieldsEnum
import com.common.http.Status.{BAD_REQUEST, OK}
import com.common.utils.DateTimeValidator.{isDateInRange, isValidDate}
import com.common.utils.Helpers.{isValidStatus, responseValidation, validateSchema}
import com.dto.closeapproach.ApproachDataResponse
import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._
import org.junit.jupiter.api.Assertions.assertTrue

object CloseApproachDataApi {

  final val CLOSE_API_URL = "/cad.api"

  def fetchCloseApproachData: ChainBuilder =
    exec(http("Current close-approach data for all asteroids and comets in JPL’s Small-Body DataBase")
      .get(CLOSE_API_URL)
      .check(isValidStatus(OK))
      .check(responseValidation(validateSchema[ApproachDataResponse])))

  def fetchCloseCometsInDateRange(date_min: String, date_max: String): ChainBuilder =
    exec(http("Close-approach data for parametrized request with date ranges")
      .get(CLOSE_API_URL)
      .queryParam("des", "433")
      .queryParam("date-min", date_min)
      .queryParam("date-max", date_max)
      .queryParam("dist-max", "0.2")
      .check(isValidStatus(OK))
      .check(responseValidation(validateSchema[ApproachDataResponse]))
      .check(jsonPath("$..data[*]").ofType[Seq[Any]].findAll.saveAs("dataArray"))
      .check(jsonPath("$..fields[*]").findAll.saveAs("fieldsArray")))
      .exec(session => {
        session("fieldsArray").as[Vector[String]].toList.foreach(f => assertTrue(FieldsEnum.isOrderType(f)))
        session("dataArray").as[Vector[List[String]]].toList.foreach(d => {
          val date: String = d(3)
          assertTrue(isValidDate(date))
          assertTrue(isDateInRange(date, date_min, date_max))
        })
        session
      })

  // Example of an API error test.
  def fetchCloseApproachDataBadRequest: ChainBuilder =
    exec(http("Bad Request error response test for Close Approach Api")
      .get(CLOSE_API_URL)
      .queryParam("date-min", true)
      .check(isValidStatus(BAD_REQUEST))
      .check(jsonPath("$.moreInfo").find.is("https://ssd-api.jpl.nasa.gov/doc/cad.html"))
      .check(jsonPath("$.code").find.is("400"))
      .check(jsonPath("$.message").find.is(
        "invalid value specified for query parameter 'date-min': invalid datetime specified " +
          "(expected 'YYYY-MM-DD', 'YYYY-MM-DDThh:mm:ss', 'YYYY-MM-DD_hh:mm:ss' or 'YYYY-MM-DD hh:mm:ss')")))
}
