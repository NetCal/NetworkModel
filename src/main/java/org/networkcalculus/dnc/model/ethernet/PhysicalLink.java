package org.networkcalculus.dnc.model.ethernet;

import org.networkcalculus.dnc.model.impl.LinkImpl;

public class PhysicalLink extends LinkImpl {
    
    private PhysicalLink(final NetworkInterface src, final NetworkInterface dest) {
        this.setSource(src);
        this.setDestination(dest);
    }
    
    /** 
     * A new link between two network interfaces
     * @param src {@link NetworkInterface} the source
     * @param dest {@link NetworkInterface} the destination
     * @return a new {@link NetworkInterface} object
     */
    static final PhysicalLink valueOf(final NetworkInterface src, final NetworkInterface dest) {
        return new PhysicalLink(src,dest);
    }
    
    private final void setSource(final NetworkInterface networkInterface) {
        this.setSrcPort(networkInterface.getOutPort());
    }
    
    private final void setDestination(final NetworkInterface networkInterface) {
        this.getDstPorts().add(networkInterface.getInPort());
    }
}
