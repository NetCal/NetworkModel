package org.networkcalculus.dnc.model.can;

import java.util.List;

import org.networkcalculus.dnc.model.impl.DeviceImpl;

public class ECU extends DeviceImpl {
    
    ECU(final String name) {
        this.setName(name);
    }
    
    public static final ECU valueOf(final String name) {
        return new ECU(name);
    }
    
    public CANController addController(final String name) {
        CANController controller = CANController.valueOf(name);
        controller.setDevice(this);
        this.getPorts().add(controller);
        return controller;
    }
    
    
}
