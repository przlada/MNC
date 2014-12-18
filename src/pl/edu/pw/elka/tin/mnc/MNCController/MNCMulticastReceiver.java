package pl.edu.pw.elka.tin.mnc.MNCController;

import pl.edu.pw.elka.tin.mnc.MNCConstants;
import pl.edu.pw.elka.tin.mnc.MNCDatagram;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * Created by przemek on 16.12.14.
 */
public class MNCMulticastReceiver implements Runnable {
    private MulticastSocket udpServer;
    private final MNCController parentController;

    MNCMulticastReceiver(MNCController p) throws IOException {
        parentController = p;
        udpServer = new MulticastSocket(MNCConstants.MCAST_PORT);
        InetAddress group = InetAddress.getByName(MNCConstants.MCAST_ADDR);
        udpServer.joinGroup(group);
    }
    @Override
    public void run() {
        while(true){
            byte[] buf = new byte[MNCConstants.UDP_PACAGE_MAX_SIZE];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            try {
                udpServer.receive(packet);
                MNCDatagram datagram = MNCDatagram.toMNCDatagram(packet.getData());
                System.out.println(parentController.getName()+": "+datagram);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
