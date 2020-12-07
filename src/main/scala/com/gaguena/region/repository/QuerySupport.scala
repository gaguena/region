package com.gaguena.region.repository

trait QuerySupport {

  def likeEnd(value: String) = s"$value%"

  def likeStartAndEnd(value: String) = s"%$value%"
}