package com.gaguena.region.controller.rest

import scala.concurrent.Future
import scala.util.{ Failure, Success, Try }

import org.scalatra.{ AsyncResult, BadRequest, Ok }

import com.gaguena.region.controller.support.JsonScalatraSupport
import com.gaguena.region.model.City
import com.gaguena.region.service.CityServiceComponent

class CityRest extends JsonScalatraSupport with CityServiceComponent {

  val CityRestType = "application/vnd.gaguena.autor.v1+json"

  override val acceptmediaTypes = List(CityRestType)

  post("/") {
    new AsyncResult {
      val is = {
        val body = request.body
        Try(parse(body).extract[City]) match {
          case Success(city) => {
            println(city)
            cityService.save(city)
          }
          case Failure(_) => Future.successful(BadRequest("Corpo da requisição(parametros) invalidos"))
        }
      }
    }
  }

  get("/") {
    new AsyncResult {
      val is = cityService.findAll().map(l => Ok(l))
    }
  }

  get("/:codigo") {
    new AsyncResult {
      val codigo = params("codigo").toLong
      val is = cityService.findBy(codigo).map(l => Ok(l))
    }
  }

  get("/name/:name") {
    new AsyncResult {
      val name = params("name")
      val is = cityService.findBy(name).map(l => Ok(l))
    }
  }
}