package com.gaguena.region.repository

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

import slick.driver.MySQLDriver.api._
import com.gaguena.region.model.City
import com.gaguena.region.persistence.table.CityTable


object CityRepository extends Repository[City] {

  lazy val all = TableQuery[CityTable]

  def save(city: City): Future[City] =
    transactionally((all.returning(all.map(_.id)))
      .insertOrUpdate(city).map(_.map(id => city.copy(id = id)).getOrElse(city)))

  def findAll: Future[List[City]] = transactionally(all.result.map(_.toList))

  def find(id: Long): Future[Option[City]] =
    transactionally(all.filter(_.id === Option(id)).result.map(_.headOption))

  def findBy(title: String): Future[List[City]] =
    transactionally(all.filter(_.title like likeEnd(title)).result.map(_.toList))
}