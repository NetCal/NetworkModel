package org.networkcalculus.dnc.model.ethernet;

import org.networkcalculus.dnc.model.impl.NetworkImpl;

public class EthernetNetwork extends NetworkImpl {
    
    private EthernetNetwork(final String name, final double bandwidth) {
        this.setBandwidth(bandwidth);
        this.setName(name);
    }
    
    public final static EthernetNetwork valueOf(final String name, final double bandwidth) {
        return new EthernetNetwork(name, bandwidth);
    }
    
    public final void addVirtualLink(final VirtualLink vl) {
        if (vl == null) {
            return;
        }
        this.getFlows().add(vl);
    }
}
