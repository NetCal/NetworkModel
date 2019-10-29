package org.networkcalculus.dnc.model.can;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class CANNetworkModelTest {

    @Test
    void test() {
        CANNetwork network = CANNetwork.valueOf("CAN_network");
        CANBus bus = network.addCANBus("bus", 125000);
        
        ECU publisher = network.addECU("publisher");
        bus.connectECU(publisher);
        
        ECU subscriber = network.addECU("subscriber");
        bus.connectECU(subscriber);
        
        bus.addFrame("frame", 1, publisher, Arrays.asList(subscriber));
    }

}
