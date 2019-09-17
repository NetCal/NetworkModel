package org.networkcalculus.dnc.model.can;

import org.networkcalculus.dnc.model.impl.FlowImpl;

public class CANFrame extends FlowImpl {
    
    private CANFrame(final String name, int id) {
        this.setName(name);
        this.setPriority(id);
    }
    
    public static CANFrame valueOf(final String name, int id) {
        return new CANFrame(name, id);
    }
}
