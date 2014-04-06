package twitter

import com.typesafe.config.ConfigFactory

object TwitterTokens {

  val conf = ConfigFactory.load("config.secret.conf")

  val ConsumerKey = conf.getString("consumer.key")
  val ConsumerSecret = conf.getString("consumer.secret")

  val AccessToken = conf.getString("access.token")
  val TokenSecret = conf.getString("token.secret")
}
