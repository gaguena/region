package com.gaguena.region.controller.support



import org.json4s.{ DefaultFormats, Formats }
import org.scalatra.test.specs2.MutableScalatraSpec

import com.gaguena.region.serializer.LocalDateTimeSerializer

class JsonRestTestSupport extends MutableScalatraSpec {

  def addRest(t: JsonScalatraSupport, path: String) = 
    addServlet(t, "/citys/*")

  protected implicit lazy val jsonFormats: Formats = DefaultFormats.withBigDecimal + LocalDateTimeSerializer

}