package com.gaguena.region.controller.support



import org.json4s.{ DefaultFormats, Formats }
import org.scalatra.test.specs2.MutableScalatraSpec

import com.gaguena.region.serializer.LocalDateTimeSerializer

class JsonScalatraTestSupport extends MutableScalatraSpec {

  def addRest(rest: JsonScalatraSupport, path: String) = 
    addServlet(rest, "/citys/*")

  protected implicit lazy val jsonFormats: Formats = DefaultFormats.withBigDecimal + LocalDateTimeSerializer

}