import org.junit.Test;

import static org.junit.Assert.*;

public class SortBasedOnPortTest {

    @Test
    public void compare() {
        SortBasedOnPort sortBasedOnPort=new SortBasedOnPort();
        Rules rule=new Rules("inbound,tcp,80,192.168.1.2");
        Rules rule1=new Rules("outbound,udp,64-90,192.168.4.100-192.168.5.50");
        Rules rule2=new Rules("outbound,udp,90-95,192.168.4.100-192.168.5.50");
        Rules rule3=new Rules("outbound,udp,80,192.168.4.100-192.168.5.50");
        Rules rule4=new Rules("outbound,udp,80-95,192.168.4.100-192.168.5.50");
        assertEquals(1,sortBasedOnPort.compare(rule,rule1));
        assertEquals(-1,sortBasedOnPort.compare(rule,rule2));
        assertEquals(0,sortBasedOnPort.compare(rule3,rule4));
        assertEquals(0,sortBasedOnPort.compare(rule,rule4));
    }
}