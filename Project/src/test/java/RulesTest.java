import org.junit.Test;

import static org.junit.Assert.*;

public class RulesTest {

    @Test
    public void ValidConstruction(){
        Rules rule=new Rules("inbound,tcp,80,192.168.1.2");
        Rules rule1=new Rules("outbound,udp,64-90,192.168.4.100-192.168.5.50");

        assertEquals("inbound",rule.getDirection());
        assertEquals("outbound",rule1.getDirection());

        assertEquals("tcp",rule.getProtocol());
        assertEquals("udp",rule1.getProtocol());

        assertEquals(80,rule.getStartPort());
        assertEquals(64,rule1.getStartPort());

        assertEquals(80,rule.getEndPort());
        assertEquals(90,rule1.getEndPort());
    }

    @Test
    public void getDirection() {
        Rules rule=new Rules("inbound,tcp,80,192.168.1.2");
        assertEquals("inbound",rule.getDirection());

        Rules rule1=new Rules("outbound,udp,64,192.168.4.100-192.168.5.50");
        assertEquals("outbound",rule1.getDirection());
    }

    @Test
    public void getProtocol() {
        Rules rule=new Rules("inbound,tcp,80,192.168.1.2");
        assertEquals("tcp",rule.getProtocol());

        Rules rule1=new Rules("outbound,udp,64,192.168.4.100-192.168.5.50");
        assertEquals("udp",rule1.getProtocol());
    }

    @Test
    public void getStartPort() {
        Rules rule=new Rules("inbound,tcp,80,192.168.1.2");
        assertEquals(80,rule.getStartPort());

        Rules rule1=new Rules("outbound,udp,64-90,192.168.4.100-192.168.5.50");
        assertEquals(64,rule1.getStartPort());
    }

    @Test
    public void getEndPort() {
        Rules rule=new Rules("inbound,tcp,80,192.168.1.2");
        assertEquals(80,rule.getEndPort());

        Rules rule1=new Rules("outbound,udp,64-90,192.168.4.100-192.168.5.50");
        assertEquals(90,rule1.getEndPort());
    }

    @Test
    public void isInRange() {
        Rules rule=new Rules("inbound,tcp,80,192.168.1.2");
        assertEquals(true,rule.isInRange("192.168.1.2"));
        assertEquals(false,rule.isInRange("193.168.1.2"));

        Rules rule1=new Rules("outbound,udp,64-90,192.168.4.100-192.168.5.50");
        assertEquals(true,rule1.isInRange("192.168.4.200"));
        assertEquals(true,rule1.isInRange("192.168.5.2"));
        assertEquals(false,rule1.isInRange("192.168.4.1"));
        assertEquals(false,rule1.isInRange("192.168.5.200"));
        assertEquals(false,rule1.isInRange("193.168.5.200"));

    }
}