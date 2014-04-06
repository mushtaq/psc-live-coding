package library

import play.api.libs.ws.WS.WSRequestHolder
import play.api.libs.iteratee.Concurrent
import java.lang.String
import library.EnumeratorImplicits.RichEnumerator
import utils.Config.executionContext

object RequestHolderImplicits {

  implicit class RichRequestHolder(val requestHolder: WSRequestHolder) extends AnyVal {

    def enumerate = {
      val (iteratee, enumerator) = Concurrent.joined[Array[Byte]]
      requestHolder.get(_ => iteratee)
      enumerator
    }

    def lineChunks = enumerate.map(bytes => new String(bytes))
    def lineStream = lineChunks.toObservable
  }
}
