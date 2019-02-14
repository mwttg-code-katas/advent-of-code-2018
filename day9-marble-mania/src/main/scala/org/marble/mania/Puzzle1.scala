package org.marble.mania

object Puzzle1 extends App {

  val playerStatus     = Players().initialize(30)
  val winningCondition = WinningCondition(37305)
  val marbleStatus     = Marbles(2, 1)
  val marbles          = List(0, 1)

  var playboard = Playboard(
    marbles,
    marbleStatus,
    playerStatus,
    winningCondition
  )

  do {
    playboard = playboard.insert()
  } while (true)
}
/**
  * Puzzle seems broken
  *
  * 10 players; last marble is worth 1618 points: high score is 8317        --> highscore reached but last marble was worth 1610
  * 13 players; last marble is worth 7999 points: high score is 146373      --> highscore reached but last marble was worth 7981
  * 17 players; last marble is worth 1104 points: high score is 2764        --> highscore reached but last marble was worth 1104
  * 21 players; last marble is worth 6111 points: high score is 54718       --> highscore reached but last marble was worth 6095
  * 30 players; last marble is worth 5807 points: high score is 37305       --> highscore reached but last marble was worth 5750
  *
  * or i made an mistake ;)
  */
