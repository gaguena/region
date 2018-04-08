package com.gaguena.region.controller.support

import scala.concurrent.ExecutionContext

import org.json4s.{ DefaultFormats, Formats }
import org.scalatra._
import org.scalatra.json.JacksonJsonSupport
import org.slf4j.LoggerFactory

import akka.actor.ActorSystem
import com.gaguena.region.serializer.LocalDateTimeSerializer

trait JsonScalatraSupport extends ScalatraServlet
    with ContentSupport
    with FutureSupport
    with JacksonJsonSupport
    with UrlGeneratorSupport {

  protected implicit def executor: ExecutionContext = ActorSystem().dispatcher

  protected implicit lazy val jsonFormats: Formats = DefaultFormats.withBigDecimal + LocalDateTimeSerializer

  private[this] val logger = LoggerFactory.getLogger(getClass)
    
  before() {
    contentType = formats("json")
  }

  private def resultMessage(message: String){
    ResponseMessage(message)
  }

  def badRequest(message: String) = {
    logger.info(s"BadRequest: $message" )
    BadRequest(resultMessage(message))
  }
  
   def notFound(message: String) = {
    logger.info(s"NotFound: $message" )
    NotFound(resultMessage(message))
  }
}