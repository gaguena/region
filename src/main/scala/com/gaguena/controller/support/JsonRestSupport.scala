package com.gaguena.controller.support

import org.json4s._
import org.scalatra.ScalatraServlet
import org.scalatra.json.JacksonJsonSupport

trait JsonRestSupport extends ScalatraServlet with JacksonJsonSupport {

  protected implicit lazy val jsonFormats: Formats = DefaultFormats.withBigDecimal

  before() {
    contentType = formats("json")
  }
}