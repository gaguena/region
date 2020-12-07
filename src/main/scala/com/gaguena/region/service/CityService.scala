package com.gaguena.region.service

import scala.concurrent.ExecutionContext.Implicits.global

import scala.concurrent.Future
import com.gaguena.region.repository.CityRepository
import com.gaguena.region.model.City
import com.gaguena.region.exception.AppException

trait CityServiceComponent {
  val cityService = new CityService
}

class CityService {

  private def failed[T](message: String): Future[T] = Future.failed(throw new AppException(message))
  
  def save(city: City) = CityRepository.save(city)

  def findAll(): Future[List[City]] = CityRepository.findAll

  def findBy(id: Long) = CityRepository.find(id)
  
  def findBy(name: String) = CityRepository.findBy(name)
}