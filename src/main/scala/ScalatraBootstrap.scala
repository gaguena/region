import org.scalatra._
import javax.servlet.ServletContext
import com.gaguena.region.controller.rest.CityRest

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {
    context.mount(new CityRest, "/citys/*")
  }
}
