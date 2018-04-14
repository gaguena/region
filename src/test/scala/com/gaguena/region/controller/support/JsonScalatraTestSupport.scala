package com.gaguena.region.controller.support

import org.json4s.{ DefaultFormats, Formats }
import org.scalatra.test.specs2.MutableScalatraSpec

import com.gaguena.region.serializer.LocalDateTimeSerializer
import scala.reflect.ClassTag
import scala.reflect.classTag

class JsonScalatraTestSupport extends MutableScalatraSpec with JsonOps {

  def mount[T <: JsonScalatraSupport](t: T, path: String) =
    addServlet(t, "/citys/*")

  protected implicit lazy val jsonFormats: Formats = DefaultFormats.withBigDecimal + LocalDateTimeSerializer

}