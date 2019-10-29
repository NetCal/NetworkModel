package org.networkcalculus.dnc.model.can;

import java.util.ArrayList;
import java.util.List;

import org.networkcalculus.dnc.model.impl.NetworkImpl;

/**
 * Class representation of the CAN network with several 1..n CAN buses
 * @author matyesz
 *
 */
public class CANNetwork extends NetworkImpl {
    
    private CANNetwork(final String name) {
        this.setName(name);
    }
    
    /**
     * Static constructor
     * @param name - the name of the network
     * @return the {@link CANNetwork} instance
     */
    final static public CANNetwork valueOf(final String name) {
        return new CANNetwork(name);
    }
    
    /**
     * Adds a new bus to the network
     * @param name - the name of the bus must be unique within the network
     * @param bandwidth - the bandwidth in bps
     * @return the {@link CANBus] instance
     */
    final public CANBus addCANBus(final String name, final double bandwidth) {
        final CANBus result = CANBus.valueOf(name, bandwidth);
        this.getDevices().add(result);
        return result;
    }
    
    /**
     * Adds an ECU to the network
     * @param name - the name of the ECU must be unique within the network
     * @return the {@link ECU} instance
     */
    final public ECU addECU(final String name) {
        final ECU result = ECU.valueOf(name);
        this.getDevices().add(result);
        return result;
    }
    
    /**
     * Returns all CAN buses in the network
     * @return {@link ArrayList} of {@link CANBus} or empty list
     */
    final public List<CANBus> getCANBuses() {
        List<CANBus> result = new ArrayList<CANBus>();
        for (final var device : this.getDevices()) {
            if (device instanceof CANBus) {
                result.add((CANBus)device);
            }
        }
        return result;
    }
    
    /**
     * Returns all ECUs in the network
     * @return {@link ArrayList} of {@link ECU} or empty list
     */
    final public List<ECU> getECUs() {
        List<ECU> result = new ArrayList<ECU>();
        for (final var device : this.getDevices()) {
            if (device instanceof ECU) {
                result.add((ECU)device);
            }
        }
        return result;
    }
    
}
