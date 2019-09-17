package org.networkcalculus.dnc.model.can;

import org.networkcalculus.dnc.model.impl.DeviceImpl;

/**
 * Class representing a Controller Area Network bus.
 * @author matyesz
 *
 */
public class CANBus extends DeviceImpl {
    
    private CANBus(final String name, final double bandwidth) {
        this.setName(name);
    }
    
    /**
     * Static constructor
     * @param name the unique name of the bus
     * @param bandwidth the network speed in bps
     * @return {@link CANBus} the new object
     */
    public static final CANBus valueOf(final String name, final double bandwidth) {
        return new CANBus(name, bandwidth);
    }
    
    public final ECU addECU() 
}
