package org.networkcalculus.dnc.model.ethernet;

import java.util.ArrayList;
import java.util.List;

import org.networkcalculus.dnc.model.ethernet.avb.AVBClass;
import org.networkcalculus.dnc.model.ethernet.avb.AVBVirtualLink;
import org.networkcalculus.dnc.model.ethernet.rc.Priority;
import org.networkcalculus.dnc.model.ethernet.rc.RCVirtualLink;
import org.networkcalculus.dnc.model.impl.NetworkImpl;

/**
 * Class representing an ethernet network
 * @author matyesz
 *
 */
public class EthernetNetwork extends NetworkImpl {
    
    private EthernetNetwork(final String name, final double bandwidth) {
        this.setBandwidth(bandwidth);
        this.setName(name);
    }
    
    /**
     * Static constructor
     * @param name the name of the network
     * @param bandwidth bandwidth of the network in bits/second
     * @return {@link EthernetNetwork} a new network object
     */
    public final static EthernetNetwork valueOf(final String name, final double bandwidth) {
        return new EthernetNetwork(name, bandwidth);
    }
    
    /**
     * Adds a new virtual link to the network
     * @param name the name of the VL
     * @param bag the retransmission rate of the VL in seconds
     * @param priority priority of the VL
     * @param maxLength the maximum packet length on the VL in bits
     * @return new {@link RCVirtualLink} object
     */
    public final VirtualLink addRCVirtualLink(final String name, final double bag, final Priority priority,
	    final int maxLength) {
        if (name == null || name.isEmpty()) {
            return null;
        }
	VirtualLink vl = RCVirtualLink.valueOf(name, bag, priority, maxLength);
        this.getFlows().add(vl);
        return vl;
    }
    
    public final VirtualLink addAVBVirtualLink(final String name, final double bag, final AVBClass avbClass,
	    final int maxLength) {
	if (name == null || name.isEmpty()) {
	    return null;
	}
	VirtualLink vl = AVBVirtualLink.valueOf(name, bag, avbClass, maxLength);
	this.getFlows().add(vl);
	return vl;
    }

    /**
     * all VLs in the network.
     * @return {@link ArrayList} of all VLs
     */
    public final List<VirtualLink> getVirtualLinks() {
	final List<VirtualLink> result = new ArrayList<VirtualLink>();
        for (final var flow : this.getFlows()) {
	    result.add((VirtualLink) flow);
        }
        return result;
    }
    
    /**
     * Adds a new end-system to the network.
     * @param name the name of the end-system
     * @return new {@link EndSystem} instance
     */
    public final EndSystem addEndSystem(final String name) {
        if (name == null || name.isEmpty()) {
            return null;
        }
        EndSystem es = EndSystem.valueOf(name);
        this.getDevices().add(es);
        return es;
    }
    
    /**
     * A {@link List} of all end-systems in the network
     * @return a {@link ArrayList} of all end-systems within the network
     */
    public final List<EndSystem> getEndSystems() {
       final List<EndSystem> result = new ArrayList<EndSystem>();
       for (final var device : this.getDevices()) {
           if (device instanceof EndSystem) {
               result.add((EndSystem)device);
           }
       }
       return result;
    }
    
    /**
     * Adds a new switch to the network.
     * @param name the name of the switch
     * @return new {@link Switch} instance
     */
    public final Switch addSwitch(final String name) {
        if (name == null || name.isEmpty()) {
            return null;
        }
        Switch sw = Switch.valueOf(name);
        this.getDevices().add(sw);
        return sw;
    }
    
    /**
     * A {@link List} of all switches in the network
     * @return a {@link ArrayList} of all switches within the network
     */
    public final List<Switch> getSwitches() {
        final List<Switch> result = new ArrayList<Switch>();
        for (final var device : this.getDevices()) {
            if (device instanceof Switch) {
                result.add((Switch)device);
            }
        }
        return result;
     }
    
    /** Adds a new link between two network interfaces
     * @param src {@link NetworkInterface} the source
     * @param dest {@link NetworkInterface} the destination
     * @return a new {@link NetworkInterface} object
     */
    public final PhysicalLink addPhysicalLink(final NetworkInterface src, final NetworkInterface dest) {
        if (src == null || dest == null) {
            return null;
        }
        PhysicalLink link = PhysicalLink.valueOf(src, dest);
        this.getLinks().add(link);
        return link;
    }
    
    /**
     * A {@link List} of all physical links in the network
     * @return {@link ArrayList} of {@link PhysicalLink}
     */
    public final List<PhysicalLink> getPhysicalLinks() {
        final List<PhysicalLink> result = new ArrayList<PhysicalLink>();
        for (final var link : this.getLinks()) {
            result.add((PhysicalLink)link);
        }
        return result;
    }
    
    public String toString() {
        final StringBuilder result = new StringBuilder();
        for (final var vl : this.getFlows()) {
            result.append(vl.toString());
            result.append("\n");
        }
        return result.toString();
    }
}
