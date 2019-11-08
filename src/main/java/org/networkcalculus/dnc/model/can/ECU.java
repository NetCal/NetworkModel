package org.networkcalculus.dnc.model.can;

import org.networkcalculus.dnc.model.impl.DeviceImpl;

/**
 * Class representation of an ECU
 * @author matyesz
 *
 */
public class ECU extends DeviceImpl {
    
    private ECU(final String name, final double internalLatency) {
        this.setName(name);
        this.setInternalLatency(internalLatency);
    }
    
    /**
     * Static constructor
     * @param name - the name of the ECU must be unique within the network
     * @return the {@link ECU} instance
     */
    public static final ECU valueOf(final String name, final double internalLatency) {
        return new ECU(name, internalLatency);
    }
    
    
    public static final ECU valueOf(final String name) {
        return new ECU(name, 0.0);
    }
    /**
     * Adds a new CAN controller to the ECU
     * @param name - the name of the controller, must be unique within the ECU
     * @param type - the type of the CAN controller
     * @return the {@link CANController} instance
     */
    public CANController addController(final String name, final ECANControllerType type) {
        CANController controller = CANController.valueOf(this.getName() + "_" + name, type);
        controller.setDevice(this);
        this.getPorts().add(controller);
        return controller;
    }
    
    
}
