package twitter

import play.api.libs.oauth.{RequestToken, ConsumerKey, OAuthCalculator}
import play.api.libs.ws.WS
import library.RequestHolderImplicits.RichRequestHolder
import play.api.libs.iteratee.{Iteratee, Enumeratee}
import utils.Config.executionContext
import library.EnumeratorImplicits.RichEnumerator
import play.api.libs.json.{JsObject, Json}

object TwitterClient {

  val oAuthCalculator = OAuthCalculator(
    ConsumerKey(TwitterTokens.ConsumerKey, TwitterTokens.ConsumerSecret),
    RequestToken(TwitterTokens.AccessToken, TwitterTokens.TokenSecret)
  )

  val takeTweet = for {
    line <- Enumeratee.takeWhile[String](! _.endsWith("\r\n")) &>> Iteratee.getChunks[String]
    lastLine  <- Enumeratee.take(1) &>> Iteratee.getChunks[String]
  } yield (line ::: lastLine).mkString

  val asTweet = Enumeratee.grouped(takeTweet)

   def getJsonStream(url: String) = WS
    .url(url)
    .sign(oAuthCalculator)
    .lineChunks
    .through(asTweet)
    .toObservable
    .map(chunk => Json.parse(chunk).as[JsObject])
}
