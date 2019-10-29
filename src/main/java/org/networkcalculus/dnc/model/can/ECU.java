package org.networkcalculus.dnc.model.can;

import org.networkcalculus.dnc.model.impl.DeviceImpl;

/**
 * Class representation of an ECU
 * @author matyesz
 *
 */
public class ECU extends DeviceImpl {
    
    private ECU(final String name) {
        this.setName(name);
    }
    
    /**
     * Static constructor
     * @param name - the name of the ECU must be unique within the network
     * @return the {@link ECU} instance
     */
    static final ECU valueOf(final String name) {
        return new ECU(name);
    }
    
    /**
     * Adds a new CAN controller to the ECU
     * @param name - the name of the controller, must be unique within the ECU
     * @return the {@link CANController} instance
     */
    CANController addController(final String name) {
        CANController controller = CANController.valueOf(name);
        controller.setDevice(this);
        this.getPorts().add(controller);
        return controller;
    }
    
    
}
