package com.gaguena.region.controller.support

import org.json4s._
import scala.reflect.ClassTag

import scala.reflect.ClassTag
import org.json4s.jackson.Serialization

import org.json4s.jackson.JsonMethods._
import org.json4s.jackson.Serialization._

trait JsonOps {

  implicit class Serialization[A <: AnyRef](src: A) {
    def json(implicit format: Formats) = write(src)
  }

  implicit class Deserialization(src: String) {
    def fromJson[A](implicit format: Formats, mf: Manifest[A]): A =
      if (src.trim.nonEmpty) read(src)(format, mf) else throw new IllegalArgumentException("Empty source")
  }
}