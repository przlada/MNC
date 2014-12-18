package pl.edu.pw.elka.tin.mnc.MNCController;

import pl.edu.pw.elka.tin.mnc.MNCConstants;
import pl.edu.pw.elka.tin.mnc.MNCDatagram;

import java.io.IOException;
import java.net.*;

/**
 * Created by przemek on 16.12.14.
 */
public class MNCController {
    private String name;
    private DatagramSocket udpClient;
    private InetAddress mcastGroup;
    private Thread mcastReceiver;

    public String getName(){
        return name;
    }
    public MNCController(String n) throws SocketException, UnknownHostException {
        name = n;
        udpClient = new DatagramSocket();
        mcastGroup = InetAddress.getByName(MNCConstants.MCAST_ADDR);
        try {
            mcastReceiver = new Thread(new MNCMulticastReceiver(this));
            mcastReceiver.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendDatagram(MNCDatagram d) throws IOException {
        byte data[] = MNCDatagram.toByteArray(d);
        DatagramPacket packet = new DatagramPacket(data, data.length, mcastGroup, MNCConstants.MCAST_PORT);
        udpClient.send(packet);
    }

}