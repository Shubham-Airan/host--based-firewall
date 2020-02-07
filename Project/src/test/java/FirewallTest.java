import org.junit.Test;

import static org.junit.Assert.*;

public class FirewallTest {

    @Test
    public void accept_packet() {
        Firewall firewall=new Firewall("E:\\MS\\Interview project\\host--based-firewall\\Project\\Rules.csv");
        assertEquals(true,firewall.accept_packet("inbound", "tcp", 80, "192.168.1.2"));
        assertEquals(true,firewall.accept_packet("inbound", "udp", 53, "192.168.2.1"));
        assertEquals(true,firewall.accept_packet("outbound", "tcp", 10234, "192.168.10.11"));
        assertEquals(false,firewall.accept_packet("inbound", "tcp", 81, "192.168.1.2"));
        assertEquals(false,firewall.accept_packet("inbound", "udp", 24, "52.12.48.92"));

    }
}