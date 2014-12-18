package pl.edu.pw.elka.tin.mnc;

import java.io.*;

/**
 * Created by przemek on 16.12.14.
 */
public class MNCDatagram implements Serializable{
    private MNCAddress sender;
    private MNCAddress receiver;
    private int type;

    public MNCDatagram(String s, String r, int t){
        type = t;
        sender = new MNCAddress(s);
        receiver = new MNCAddress(r);
    }
    public String toString(){
        return "Komunikat - t:"+type+" s:"+sender+" r:"+receiver;
    }

    public static byte[] toByteArray(MNCDatagram d) throws IOException {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        ObjectOutputStream o = new ObjectOutputStream(b);
        o.writeObject(d);
        byte[] array = b.toByteArray();
        if(array.length > MNCConstants.UDP_PACAGE_MAX_SIZE) {
            throw new IOException();
        }
        return b.toByteArray();
    }
    public static MNCDatagram toMNCDatagram(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream b = new ByteArrayInputStream(bytes);
        ObjectInputStream o = new ObjectInputStream(b);
        return (MNCDatagram)o.readObject();
    }
}
