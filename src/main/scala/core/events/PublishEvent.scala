package core.events

import core.model._
import core.ApplicationState
import calculation._

class PublishEvent(draw: Draw) {

  def process() = {
    val quota = QuotaCalculation.calculate(draw)
    ApplicationState.addQuota(quota)
  }

  override def toString(): String = {
    "draw.id=" + draw.id
  }
}

object PublishEvent {

  def fromString(string: String) = {
    val drawId = string.split("=")(1)
    val draw = Draw(id = drawId)
    new PublishEvent(draw)
  }
}