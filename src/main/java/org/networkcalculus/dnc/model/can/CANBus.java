package org.networkcalculus.dnc.model.can;

import org.networkcalculus.dnc.model.impl.DeviceImpl;

public class CANBus extends DeviceImpl {
    
    private CANBus(final String name, final double bandwidth) {
        this.setName(name);
    }
    
    public static final CANBus valueOf(final String name, final double bandwidth) {
        return new CANBus(name, bandwidth);
    }
}
