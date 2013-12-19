package gui

import core._
import core.model._
import core.events._

object Main {

  def main(args: Array[String]) {
    init();
    showOptions();
    while (true) {
      var task = Console.readLine()
      processTask(task)
    }
  }

  def processTask(task: String) = {
    task match {
      case "help" => showOptions()
      case "list" => showListOfDraws()
      case t if t.startsWith("publish") => publishDraw(t)
    }
  }

  def showOptions() = {
    println("QS Prototype");
    println("Options:");
    println("  * help");
    println("  * list");
    println("  * publish <drawId>");
  }

  def showListOfDraws() = {
    for (draw <- ApplicationState.retrieveQuotas()) yield {
      println(draw)
    }
  }

  def publishDraw(publishCommand: String) = {
    val drawId = publishCommand.split(" ")(1)
    val draw = Draw(id = drawId)
    val event = new PublishEvent(draw = draw)
    event.process()
    EventLog.registerEvent(event)
  }

  def init() = {
    for (event <- EventLog.retrieveAllEvents()) {
      event.process()
    }
  }
}