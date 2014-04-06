package utils

import java.util.concurrent.Executors
import scala.concurrent.ExecutionContext

object Config extends Config(numberOfThreads = 4)
object BlockingConfig extends Config(numberOfThreads = 4)

class Config(numberOfThreads: Int) {
  val threadPool = Executors.newScheduledThreadPool(numberOfThreads)
  implicit val executionContext = ExecutionContext.fromExecutorService(threadPool)
}
