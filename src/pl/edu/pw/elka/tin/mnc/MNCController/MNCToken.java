package pl.edu.pw.elka.tin.mnc.MNCController;

import pl.edu.pw.elka.tin.mnc.MNCAddress;
import pl.edu.pw.elka.tin.mnc.MNCConstants;

import java.io.Serializable;
import java.util.TreeSet;

/**
 * Created by przemek on 16.12.14.
 */
public class MNCToken implements Serializable{
    String group;
    TreeSet<MNCAddress> tree;
    public MNCToken(String g){
        group = g;
        tree = new TreeSet<MNCAddress>();
    }
    public String getGroup(){
        return group;
    }
    public void addMNCAddress(MNCAddress address){
        if(address.getControllerType() != MNCAddress.TYPE.CONTROLLER_GROUP){
            tree.add(address);
        }
    }

    public String toString(){
        String text = "Grupa: "+group+ MNCConstants.LOCAL_LINE_SEPARATOR;
        int i=1;
        for(MNCAddress elem : tree){
            text+=i+" "+elem+MNCConstants.LOCAL_LINE_SEPARATOR;
            i++;
        }
        return text;
    }
}