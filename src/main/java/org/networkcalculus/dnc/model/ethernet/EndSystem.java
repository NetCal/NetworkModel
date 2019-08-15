package org.networkcalculus.dnc.model.ethernet;

import org.networkcalculus.dnc.model.impl.DeviceImpl;

public class EndSystem extends DeviceImpl {
    
    public void addNetworkInterface(final NetworkInterface networkInterface) {
        this.getPorts().add(networkInterface);
    }
}
