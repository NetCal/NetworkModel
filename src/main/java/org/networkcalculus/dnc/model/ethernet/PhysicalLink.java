package org.networkcalculus.dnc.model.ethernet;

import org.networkcalculus.dnc.model.impl.LinkImpl;

public class PhysicalLink extends LinkImpl {
    
    private PhysicalLink(final NetworkInterface src, final NetworkInterface dest) {
        this.setSource(src);
        this.setDestination(dest);
    }
    
    public static final PhysicalLink valueOf(final NetworkInterface src, final NetworkInterface dest) {
        return new PhysicalLink(src,dest);
    }
    
    public final void setSource(final NetworkInterface networkInterface) {
        this.setSrcPort(networkInterface.getOutPort());
    }
    
    public final void setDestination(final NetworkInterface networkInterface) {
        this.getDstPorts().add(networkInterface.getInPort());
    }
}
