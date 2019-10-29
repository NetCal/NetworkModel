package org.networkcalculus.dnc.model.can;

import java.util.ArrayList;
import java.util.List;

import org.networkcalculus.dnc.model.impl.NetworkImpl;

public class CANNetwork extends NetworkImpl {
    
    private CANNetwork(final String name) {
        this.setName(name);
    }
    
    final static public CANNetwork valueOf(final String name) {
        return new CANNetwork(name);
    }
    
    final public CANBus addCANBus(final String name, final double bandwidth) {
        final CANBus result = CANBus.valueOf(name, bandwidth);
        this.getDevices().add(result);
        return result;
    }
    
    final public ECU addECU(final String name) {
        final ECU result = ECU.valueOf(name);
        this.getDevices().add(result);
        return result;
    }
    
    final public List<CANBus> getCANBuses() {
        List<CANBus> result = new ArrayList<CANBus>();
        for (final var device : this.getDevices()) {
            if (device instanceof CANBus) {
                result.add((CANBus)device);
            }
        }
        return result;
    }
    
    
}
