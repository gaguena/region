package com.gaguena.region.persistence.table

import java.time.LocalDateTime

import com.gaguena.region.persistence.DataBaseConversion._

import slick.driver.MySQLDriver.api._
import com.gaguena.region.model.City

class CityTable(tag: Tag) extends Table[City](tag, "city") {
  def id = column[Option[Long]]("id", O.PrimaryKey, O.AutoInc)
  def idState = column[Long]("id_state")
  def title = column[String]("title")
  def iso = column[Int]("iso")
  def ddd = column[Int]("iso_ddd")
  def population = column[Int]("population")
  def lat = column[String]("lat")
  def lng = column[String]("lng")
  def createAt = column[Option[LocalDateTime]]("created_at")
  def updateAt = column[Option[LocalDateTime]]("updated_at")
  def * = (id, idState, title, iso, ddd, population, lat, lng, createAt, updateAt) <> (City.tupled, City.unapply)
}
