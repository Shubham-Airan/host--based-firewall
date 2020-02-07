import java.net.InetAddress;

public class Rules {

    private String direction;
    private String protocol;
    private int startPort;
    private int endPort;
    private String start_IPAddress;
    private String end_IPAddress;
    private String[] startIPOctets;
    private String[] endIPOctets;

    Rules(String individualRule) {
        String[] ruleParameter = individualRule.split(",");
        setDirection(ruleParameter[0]);
        setProtocol(ruleParameter[1]);
        setPort(ruleParameter[2]);
        set_IPInfo(ruleParameter[3]);
    }

    private void setDirection(String direction) {
        this.direction = direction;
    }

    private void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    private void setPort(String port) {
        if (port.indexOf('-') == -1) {
            this.startPort = Integer.parseInt(port);
            this.endPort = startPort;
        } else {
            String[] ports;
            ports = port.split("-");
            this.startPort = Integer.parseInt(ports[0]);
            this.endPort = Integer.parseInt(ports[1]);
        }
    }

    private void set_IPInfo(String IPAddress) {
        if (IPAddress.indexOf('-') == -1) {
            this.start_IPAddress = IPAddress;
            this.startIPOctets = start_IPAddress.split("\\.");
            this.endIPOctets = startIPOctets;
            this.end_IPAddress = start_IPAddress;
        } else {
            String[] ips;
            ips = IPAddress.split("-");
            this.start_IPAddress = ips[0];
            this.end_IPAddress = ips[1];
            this.startIPOctets = start_IPAddress.split("\\.");
            this.endIPOctets = end_IPAddress.split("\\.");
        }
    }

    public String getDirection() {
        return direction;
    }

    public String getProtocol() {
        return protocol;
    }

    public int getStartPort() {
        return startPort;
    }

    public int getEndPort() {
        return endPort;
    }

    private long ipToLong(InetAddress ip) {
        byte[] octets = ip.getAddress();
        long result = 0;
        for (byte octet : octets) {
            result <<= 8;
            result |= octet & 0xff;
        }
        return result;
    }

    boolean isPacketIPInRange(String packet_IPAddress) {
        try {
            long start_IP = ipToLong(InetAddress.getByName(start_IPAddress));
            long end_IP = ipToLong(InetAddress.getByName(end_IPAddress));
            long packet_IP = ipToLong(InetAddress.getByName(packet_IPAddress));
            return (packet_IP >= start_IP && packet_IP <= end_IP);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}