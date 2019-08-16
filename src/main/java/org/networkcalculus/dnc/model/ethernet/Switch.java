package org.networkcalculus.dnc.model.ethernet;

import org.networkcalculus.dnc.model.impl.DeviceImpl;

public class Switch extends DeviceImpl {
    
    private Switch(final String name) {
        
    }
    
    static final Switch valueOf(final String name) {
        return new Switch(name);
    }
    
    public final NetworkInterface addNetworkInterface(final String name) {
        final NetworkInterface networkInterface = NetworkInterface.valueOf(name);
        this.getPorts().add(networkInterface);
        networkInterface.setDevice(this);
        return networkInterface;
    }
}
