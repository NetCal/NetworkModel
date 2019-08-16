package org.networkcalculus.dnc.model.ethernet;

import org.networkcalculus.dnc.model.InPort;
import org.networkcalculus.dnc.model.NetworkFactory;
import org.networkcalculus.dnc.model.OutPort;
import org.networkcalculus.dnc.model.impl.PortImpl;

public class NetworkInterface extends PortImpl {
    
    private static final String OUT = "OUT";
    private static final String IN = "IN";
    
    private InPort inPort = NetworkFactory.INSTANCE.createInPort();
    private OutPort outPort = NetworkFactory.INSTANCE.createOutPort();
    
    private NetworkInterface(final String name) {
        inPort.setName(name + IN);
        outPort.setName(name + OUT);
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
}
