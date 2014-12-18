package pl.edu.pw.elka.tin.mnc.MNCController;

import java.io.Serializable;
import java.util.TreeSet;

/**
 * Created by przemek on 16.12.14.
 */
public class MNCToken implements Serializable{
    String group;
    TreeSet<String> tree = new TreeSet<String>();
}