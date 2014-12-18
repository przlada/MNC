package pl.edu.pw.elka.tin.mnc;

import pl.edu.pw.elka.tin.mnc.MNCController.MNCController;

import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Main {

    public static void main(String[] args) {
        try {
            MNCController reciever = new MNCController("sterownik1");
            MNCController sender = new MNCController("sterownik2");
            while(true){
                sender.sendDatagram(new MNCDatagram("sender","receiver",3));
                Thread.sleep(5000);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
