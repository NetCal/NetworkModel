package org.networkcalculus.dnc.model.can;

import org.networkcalculus.dnc.model.impl.DeviceImpl;

public class Gateway extends DeviceImpl {
    
    private Gateway(final String name) {
        this.setName(name);
    }
    
    public static final Gateway valueOf(final String name) {
        return new Gateway(name);
    }
}
