package core

import core.model.Quota

object ApplicationState {
  private var quotas: List[Quota] = Nil
  def retrieveQuotas() = {
    quotas
  }

  def addQuota(quota: Quota) = {
    println("Adding quota " + quota);
    quotas = quota :: quotas
  }
}