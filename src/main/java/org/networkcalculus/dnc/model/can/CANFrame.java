package org.networkcalculus.dnc.model.can;

import org.networkcalculus.dnc.model.impl.FlowImpl;

/**
 * Class representation of a CAN frame
 * @author matyesz
 *
 */
public class CANFrame extends FlowImpl {
    
    private CANFrame(final String name, int id) {
        this.setName(name);
        this.setPriority(id);
    }
    
    /**
     * Static constructor
     * @param name - the name of the frame must be unique within the bus
     * @param id - the id of the frame
     * @return the {@link CANFrame} instance
     */
    public static CANFrame valueOf(final String name, int id) {
        return new CANFrame(name, id);
    }
}
