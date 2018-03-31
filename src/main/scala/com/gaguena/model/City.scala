package com.gaguena.model

import java.time.LocalDateTime
import java.time.LocalDateTime.now

case class City(id: Option[Long], idState: Long, title: String, iso: Int, ddd: Int, population: Int,
    lat: String, lg: String, createAt: Option[LocalDateTime] = Some(now), updateAt: Option[LocalDateTime])
