package com.gaguena.persistence.table

import java.time.LocalDateTime

import com.gaguena.model.City
import com.gaguena.persistence.DataBaseConversion._

import slick.driver.MySQLDriver.api._

class CityTable(tag: Tag) extends Table[City](tag, "city") {
  def id = column[Option[Long]]("id", O.PrimaryKey, O.AutoInc)
  def idState = column[Long]("id_state")
  def title = column[String]("title")
  def iso = column[Int]("iso")
  def ddd = column[Int]("ddd")
  def population = column[Int]("population")
  def lat = column[String]("lat")
  def lg = column[String]("lg")
  def createAt = column[Option[LocalDateTime]]("createAt")
  def updateAt = column[Option[LocalDateTime]]("updateAt")
  def * = (id, idState, title, iso, ddd, population, lat, lg, createAt, updateAt) <> (City.tupled, City.unapply)
}
