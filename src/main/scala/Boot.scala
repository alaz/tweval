package bootstrap.liftweb

import net.liftweb.common.LazyLoggable

class Boot extends LazyLoggable {
  System.setProperty("eval.debug", "true")

  def boot {
    val eval = new com.twitter.util.Eval
    logger info "impliedClasspath %s".format(eval.impliedClassPath)
    val config = eval.apply[Symbol]( classOf[Boot].getClassLoader getResourceAsStream "Config.scala")
    assert('Config == config)
    logger info "Started"
  }
}
