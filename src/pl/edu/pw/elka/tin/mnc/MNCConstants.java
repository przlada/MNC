package pl.edu.pw.elka.tin.mnc;

import java.net.InetAddress;

/**
 * Created by przemek on 16.12.14.
 */
public interface MNCConstants {
    public static final String MCAST_ADDR = "ff02::1:1:1";
    public static final int MCAST_PORT = 4446;
    public static final int UCAST_PORT = 4446;
    public static final int UDP_PACAGE_MAX_SIZE = 1400;


    public static final int MNCDATAGRAM_WHO_HAS_TOKEN = 1;
    public static final int MNCDATAGRAM_HAVE_TOKEN = 2;
    public static final int MNCDATAGRAM_HAVE_TMP_TOKEN = 3;
    public static final int MNCDATAGRAM_WHO_IN_GROUP = 4;
    public static final int MNCDATAGRAM_DANE = 5;
    public static final int MNCDATAGRAM_IN_GROUP = 6;
    public static final int MNCDATAGRAM_TOKEN_TRANSMISSION = 7;
    public static final int MNCDATAGRAM_DISCONNECTING = 8;
}
