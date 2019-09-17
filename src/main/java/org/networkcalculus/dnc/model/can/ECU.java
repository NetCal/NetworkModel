package org.networkcalculus.dnc.model.can;

import org.networkcalculus.dnc.model.impl.DeviceImpl;

public class ECU extends DeviceImpl {
    
    ECU(final String name) {
        this.setName(name);
    }
    
    public static final ECU valueOf(final String name) {
        return new ECU(name);
    }
}
