package bootstrap.liftweb

import net.liftweb.common.LazyLoggable

class Boot extends LazyLoggable {
  def boot {
    val eval = new com.twitter.util.Eval
    val config = eval.apply[Symbol]( classOf[Boot].getClassLoader getResourceAsStream "Config.scala")
    assert('Config == config)
    logger info "Started"
  }
}
