package org.networkcalculus.dnc.model.ethernet;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.networkcalculus.dnc.model.InPort;
import org.networkcalculus.dnc.model.NetworkFactory;
import org.networkcalculus.dnc.model.OutPort;
import org.networkcalculus.dnc.model.impl.PortImpl;

public class NetworkInterface extends PortImpl {
    
    private static final String OUT = "OUT";
    private static final String IN = "IN";
    
    private final Set<VirtualLink> vls = new HashSet<>();
    private InPort inPort = NetworkFactory.INSTANCE.createInPort();
    private OutPort outPort = NetworkFactory.INSTANCE.createOutPort();
    
    private NetworkInterface(final String name) {
        inPort.setName(name + IN);
        inPort.setPort(this);
        outPort.setName(name + OUT);
        outPort.setPort(this);
    }
    
    /**
     * Static constructor
     * @param name name of the object
     * @return a new {@link NetworkInterface} object
     */
    static final NetworkInterface valueOf(final String name) {
        return new NetworkInterface(name);
    }
    
    final InPort getInPort() {
        return this.inPort;
    }
    
    final OutPort getOutPort() {
        return this.outPort;
    }
    
    final void addVirtualLink(final VirtualLink vl) {
        //Must go to generic model
        this.vls.add(vl);
    }
    
    public final Set<VirtualLink> getVirtualLinks() {
        return Collections.unmodifiableSet(this.vls);
    }
}
