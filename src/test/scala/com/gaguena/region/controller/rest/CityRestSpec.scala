package com.gaguena.region.controller.rest

import org.json4s.{ jvalue2extractable, string2JsonInput }
import org.json4s.jackson.JsonMethods.parse

import com.gaguena.region.controller.support.JsonRestTestSupport
import com.gaguena.region.model.City

class CityRestSpec extends JsonRestTestSupport {

  addRest(new CityRest, "/citys/*")

  "GET /citys/" >> {
    "Recuperar uma lista de Citys and status 200" >> {
      get("/citys/") {
        val result = parse(body).extract[List[City]]
         result.size should be_>(0)
         status must_== 200
      }
    }
  }
}