package calculation

import core._
import core.model._

object QuotaCalculation {

  def calculate(draw: Draw) = {
    Quota(quota = "quota" + draw.id, draw = draw)
  }
}