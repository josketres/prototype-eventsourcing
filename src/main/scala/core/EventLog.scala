package core

import core.events._
import java.io.FileWriter
import scala.io.Source

object EventLog {

  val ln = System.getProperty("line.separator")

  val db = "events-storage.txt"

  def registerEvent(event: PublishEvent) = {
    val fw = new FileWriter(db, true)
    try {
      fw.write(event.toString() + ln)
    } finally fw.close()
  }

  def retrieveAllEvents() = {
    try {
       Source.fromFile(db).getLines().map(PublishEvent.fromString(_))
    } catch {
      case e: Exception => Nil
     }
  }
}