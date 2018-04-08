package com.gaguena.region.service

import scala.concurrent.Future
import com.gaguena.region.repository.CityRepository
import com.gaguena.region.model.City

trait CityServiceComponent {
  val cityService = new CityService
}

class CityService {

  def save(city: City) = CityRepository.save(city)

  def findAll(): Future[List[City]] = CityRepository.findAll

  def find(id: Long) = CityRepository.find(id)
}