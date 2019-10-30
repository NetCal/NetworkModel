package org.networkcalculus.dnc.model.can;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class CANNetworkModelTest {

    @Test
    void test() {
        CANNetwork network = CANNetwork.valueOf("CAN_network");
        CANBus bus = network.addCANBus("bus", 125000);
        
        ECU publisher = network.addECU("publisher");
        CANController controller1 = publisher.addController("controller1", ECANControllerType.NON_PI);
        bus.connectECU(controller1);
        
        ECU subscriber = network.addECU("subscriber");
        CANController controller2 = subscriber.addController("controller1", ECANControllerType.NON_PI);
        bus.connectECU(controller2);
        
        bus.addFrame("frame", 1, publisher, Arrays.asList(subscriber));
    }

}
