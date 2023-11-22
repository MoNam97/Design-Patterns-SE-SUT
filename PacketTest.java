import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PacketTest {
    @Test
    public void testPacketCreation() {
        Packet p = new Packet(10);
        assertEquals(25d, p.calcCost(), 0.01d);

        Packet p2 = new Packet(20);
        assertEquals(50d, p2.calcCost(), 0.01d);
    }

    @Test
    public void testPacketSwitchTrasportMode(){
        Packet p = new Packet(10);
        assertEquals(new StandardTransportMode().getClass(), p.getTransportMode().getClass());

        p.setTransportMode(new ExpressTransportMode());
        assertEquals(new ExpressTransportMode().getClass(), p.getTransportMode().getClass());
    }

    @Test
    public void testPacketSwitchState(){
        Packet p = new Packet(10);
        assertEquals(new InTransitState().getClass(), p.getState().getClass());

        p.setState(new DeliveredState());
        assertEquals(new DeliveredState().getClass(), p.getState().getClass());
    }

    @Test
    public void testPacketGetData(){
        Packet p1 = new Packet(10);
        Packet p2 = new Packet(20);
        assertEquals("The Packet With State In-Transit is in Standard mode.\nIt costs 25.0", p1.getData());
        assertEquals("The Packet With State In-Transit is in Standard mode.\nIt costs 50.0", p2.getData());

        p1.setTransportMode(new ExpressTransportMode());
        assertEquals("The Packet With State In-Transit is in Express mode.\nIt costs 35.0", p1.getData());

        p1.setState(new DeliveredState());
        assertEquals("The Packet With State Delivered is in Express mode.\nIt costs 35.0", p1.getData());

    }

    @Test
    public void testPacketCheckContinue(){
        Packet p = new Packet(10);
        assertEquals(true, p.checkContinue());

        p.setState(new DeliveredState());
        assertEquals(false, p.checkContinue());
    }

}
