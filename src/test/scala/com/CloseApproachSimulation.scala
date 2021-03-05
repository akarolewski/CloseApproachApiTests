package com

import com.common.config.Configuration.httpConfig
import com.scenarios.CloseApproachDataApi.{fetchCloseApproachDataBadRequest, _}
import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.core.structure.ScenarioBuilder

class CloseApproachSimulation extends Simulation {

  val apiTest: ScenarioBuilder = scenario("Close Approach API Tests")
    .exec(
      fetchCloseApproachData,
      fetchCloseCometsInDateRange("1900-01-01", "2100-01-01"),
      fetchCloseApproachDataBadRequest
    )

  setUp(apiTest.inject(atOnceUsers(1)).protocols(httpConfig))
}