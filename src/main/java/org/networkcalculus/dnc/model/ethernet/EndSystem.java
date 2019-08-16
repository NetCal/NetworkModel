package org.networkcalculus.dnc.model.ethernet;

import org.networkcalculus.dnc.model.impl.DeviceImpl;

public class EndSystem extends DeviceImpl {
    
    private EndSystem(final String name) {
        this.setName(name);
    }
    
    public static final EndSystem valueOf(final String name) {
        return new EndSystem(name);
    }
    
    public final NetworkInterface addNetworkInterface(final String name) {
        final NetworkInterface networkInterface = NetworkInterface.valueOf(name);
        this.getPorts().add(networkInterface);
        networkInterface.setDevice(this);
        return networkInterface;
    }
}
