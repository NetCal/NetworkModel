package org.networkcalculus.dnc.model.ethernet;

import org.networkcalculus.dnc.model.impl.DeviceImpl;

/**
 * Class representing an ethernet end-system.
 * @author matyesz
 *
 */
public class EndSystem extends DeviceImpl {
    
    private EndSystem(final String name) {
        this.setName(name);
    }
    
    /**
     * Static constructor.
     * @param name the name of the end-system
     * @return new {@link EndSystem} instance
     */
    static final EndSystem valueOf(final String name) {
        return new EndSystem(name);
    }
    
    /**
     * Add a new network interface/port to end-system
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
