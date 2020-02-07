public class Main {
    public static void main(String[] args) {

        long startTime = System.nanoTime();
        Firewall firewall = new Firewall("E:\\MS\\Interview project\\host--based-firewall\\Project\\Rules.csv");
        long intermediateTime = System.nanoTime();
        System.out.println("Rules load time "+((intermediateTime - startTime) / 1000000)+" ns");

        System.out.println(firewall.accept_packet("inbound", "tcp", 600, "255.168.1.2"));
        System.out.println(firewall.accept_packet("inbound", "udp", 53, "192.168.2.1"));
        System.out.println(firewall.accept_packet("outbound", "tcp", 10234, "192.168.10.11"));
        System.out.println(firewall.accept_packet("inbound", "tcp", 81, "192.168.1.2"));
        System.out.println(firewall.accept_packet("inbound", "udp", 24, "52.12.48.92"));
        System.out.println(firewall.accept_packet("outbound", "udp", 64, "192.168.5.2"));
        System.out.println(firewall.accept_packet("outbound", "udp", 64, "192.168.4.200"));

        long endTime = System.nanoTime();

        System.out.println("Total packet processing time "+((endTime - intermediateTime) / 1000000)+" ns");
    }
}

