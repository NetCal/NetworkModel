package org.networkcalculus.dnc.model.can;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class CANNetworkModelTest {

    @Test
    void test() {
        CANBus bus = CANBus.valueOf("bus", 125000);
        
        ECU publisher = ECU.valueOf("publisher", 0.0);
        CANController controller1 = publisher.addController("controller1", ECANControllerType.NON_PI);
        bus.connectECU(controller1);
        
        ECU subscriber = ECU.valueOf("subscriber", 0.0);
        CANController controller2 = subscriber.addController("controller1", ECANControllerType.NON_PI);
        bus.connectECU(controller2);
        
        bus.addFrame("frame", 1, publisher, Arrays.asList(subscriber));
    }

}
