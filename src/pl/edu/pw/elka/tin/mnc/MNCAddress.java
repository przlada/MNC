package pl.edu.pw.elka.tin.mnc;

import java.io.Serializable;

/**
 * Created by przemek on 16.12.14.
 */
public class MNCAddress implements Serializable, Comparable<MNCAddress>{
    private String address;
    private int ControllerType;

    public static final class TYPE{
        public static final int MONITOR = 1;
        public static final int CONTROLLER = 2;
        public static final int CONTROLLER_GROUP = 3;
    }

    MNCAddress(String a, int t){
        ControllerType = t;
        address = a;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString(){
        return address;
    }

    public int getControllerType() {
        return ControllerType;
    }

    @Override
    public int compareTo(MNCAddress o) {
        return address.compareTo(o.address);
    }
}
