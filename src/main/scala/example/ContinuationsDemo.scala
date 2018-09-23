import scala.util.continuations._
import java.util.{Timer, TimerTask}

object ContinuationsDemo {

  def main(args: Array[String]): Unit = {
    val timer = new Timer()
    type ContinuationInputType = Unit

    def sleep(delay: Int) = shift { continue: (ContinuationInputType => Unit) =>
      timer.schedule(new TimerTask {
        val nothing: ContinuationInputType = ()
        // in a real program, we'd execute our continuation on a thread pool
        override def run() = continue(continue(continue(nothing)))
      }, delay)
    }

    reset {
      println("look, Ma ...")
      sleep(1000)
      println(" no threads!")
    }
  }
}
/*
Output:
look, Ma ...
 no threads!
 no threads!
 no threads!
 */