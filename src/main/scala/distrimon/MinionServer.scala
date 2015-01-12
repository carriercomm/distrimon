package distrimon

import java.net.InetSocketAddress
import akka.actor.ActorRef
import akka.io.Tcp.Connected

class MinionServer(val address: InetSocketAddress, manager: ActorRef) extends Server {
  var counter: Int = 0

  def handle(conn: ActorRef, info: Connected): Unit = {
    addChild[MinionHandler](s"handler$counter", manager, sender)
    counter += 1
  }
}