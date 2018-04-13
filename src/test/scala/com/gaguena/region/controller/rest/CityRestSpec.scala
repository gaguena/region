package com.gaguena.region.controller.rest

import org.json4s._
import org.json4s.jackson.JsonMethods._

import com.gaguena.region.model.City
import com.gaguena.region.controller.support.JsonScalatraTestSupport

class CityRestSpec extends JsonScalatraTestSupport {

  mount(new CityRest, "/citys/*")

  "GET /citys/" >> {
    "Recuperar uma lista de Citys and status 200" >> {
      get("/citys/") {
        val result = parse(body).extract[List[City]]
        result.size should be_>(0)
        status must_== 200
      }
    }
  }

  "GET /citys/name/:name" >> {
    "Recuperar uma lista de Citys com o nome comecando com 'O' and status 200" >> {
      get("/citys/name/O") {
        val result = parse(body).extract[List[City]]
        result.size should be_>(50)
        status must_== 200
      }
    }
  }
}