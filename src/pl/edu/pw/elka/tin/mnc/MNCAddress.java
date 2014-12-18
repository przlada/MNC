package pl.edu.pw.elka.tin.mnc;

import java.io.Serializable;

/**
 * Created by przemek on 16.12.14.
 */
public class MNCAddress implements Serializable, Comparable<MNCAddress>{
    private String address;
    MNCAddress(String a){
        address = a;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString(){
        return address;
    }

    @Override
    public int compareTo(MNCAddress o) {
        return address.compareTo(o.address);
    }
}
