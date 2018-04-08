package com.gaguena.region.model

import java.time.LocalDateTime
import java.time.LocalDateTime.now

case class City(id: Option[Long], idState: Long, title: String, iso: Int, ddd: Int, population: Int,
    lat: String, lng: String, createAt: Option[LocalDateTime] = Some(now), updateAt: Option[LocalDateTime])

/*
id         | int(11)       | NO   | PRI | NULL    | auto_increment |
| id_state   | int(11)       | NO   | MUL | NULL    |                |
| title      | varchar(50)   | NO   |     | NULL    |                |
| iso        | int(8)        | NO   |     | NULL    |                |
| iso_ddd    | varchar(6)    | NO   |     | NULL    |                |
| population | int(11)       | NO   |     | 0       |                |
| lat        | varchar(180)  | YES  |     | NULL    |                |
| lng        | varchar(180)  | YES  |     | NULL    |                |
| created_at | datetime      | YES  |     | NULL    |                |
| updated_at | datetime      | YES  |     | NULL    |                |
| status     | enum('0','1') | NO   |     | 1       |       
*/