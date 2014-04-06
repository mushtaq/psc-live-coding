package chess

case class ChessMove(user: String, move: String, ip: String)

object ChessMove {

  class ChessParseException(record: String) extends RuntimeException(s"Error in parsing $record")

  def make(record: String) = record.split(' ') match {
    case Array(user, move, ip) => ChessMove(user, move, ip)
    case _                     => throw new ChessParseException(record)
  }
}
