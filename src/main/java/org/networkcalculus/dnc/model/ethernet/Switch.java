package org.networkcalculus.dnc.model.ethernet;

import org.networkcalculus.dnc.model.impl.DeviceImpl;

public class Switch extends DeviceImpl {
    
    private Switch(final String name) {
        
    }
    
    /**
     * Static constructor
     * @param name the name of the object
     * @return new {@link Switch} object
     */
    static final Switch valueOf(final String name) {
        return new Switch(name);
    }
    
    /**
     * Add a new network interface/port to switch
     * @param name the name of the object
     * @return {@link NetworkInterface} a new network interface
     */
    public final NetworkInterface addNetworkInterface(final String name) {
        final NetworkInterface networkInterface = NetworkInterface.valueOf(name);
        this.getPorts().add(networkInterface);
        networkInterface.setDevice(this);
        return networkInterface;
    }
}
