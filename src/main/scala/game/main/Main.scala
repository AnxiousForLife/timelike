package game.main

import game.GameState
import game.assets.Items._
import game.assets.Keys._
import game.assets.Rooms._
import game.engine.Engine

object Main {
  def main(args: Array[String]) {
    val startRoom = DungeonCell
    val startDirection = startRoom.outwardDirection.left.left

    val items = Seq(Compass, Map, Locket, ExitKey, Room2Key, Room3Key, Room5Key, Room6Key, BalconyKey, Room11Key)
    val startState = new GameState(Seq((startRoom, startDirection)), startRoom, startDirection, items)

    val engine = new Engine(startState)

    import java.io._
    import sun.audio._
    import javax.sound.sampled.AudioSystem
    import javax.sound.sampled.Clip

    val file = new File("/Users/icoltharp/IdeaProjects/timelike/src/main/scala/files/music.wav")

    //val in = new FileInputStream(file)
    //val audioStream = new AudioStream(in)
    //AudioPlayer.player.start(audioStream)

    val clip = AudioSystem.getClip()
    val inputStream = AudioSystem.getAudioInputStream(file)

    clip.open(inputStream)
    clip.loop(Clip.LOOP_CONTINUOUSLY)

    engine.gameLoop()
  }
}