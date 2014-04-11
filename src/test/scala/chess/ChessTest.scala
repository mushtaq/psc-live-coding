package chess

import utils.Specification
import play.api.libs.ws.WS
import rx.lang.scala.Observable
import library.RequestHolderImplicits.RichRequestHolder
import scala.concurrent.duration.DurationInt

class ChessTest extends Specification {

  "chess" in {
    val url = "http://en.lichess.org/stream"

    val topPlayers = WS
      .url(url)
      .lineStream
//      .map(_.size)




    1 mustEqual 1
  }

  "stream" in {

    val chars = 'a' to 'z'

    val dd = Observable.interval(1.second).filter(_ % 2 == 0).map(x => chars(x.toInt))

    dd.subscribe(x => println(x), ex => println(ex.getMessage))

    Thread.sleep(10000)

    1 mustEqual 1
  }

  "time" in {

    val dd1 = Observable.interval(2.seconds).map(_ * 2)
    val dd2 = Observable.interval(3.seconds).map(_ * 3.0)

    val dd = dd1.merge(dd2)

    dd.subscribe(x => println(x))

    Thread.sleep(10000)

    1 mustEqual 1
  }
}
