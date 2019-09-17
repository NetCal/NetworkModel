package org.networkcalculus.dnc.model.can;

import org.networkcalculus.dnc.model.InPort;
import org.networkcalculus.dnc.model.NetworkFactory;
import org.networkcalculus.dnc.model.OutPort;
import org.networkcalculus.dnc.model.impl.PortImpl;

public class CANController extends PortImpl {
    
    private static final String OUT = "OUT";
    private static final String IN = "IN";
    
    private InPort inPort = NetworkFactory.INSTANCE.createInPort();
    private OutPort outPort = NetworkFactory.INSTANCE.createOutPort();
    
    private CANController(final String name) {
        inPort.setName(name + IN);
        inPort.setPort(this);
        outPort.setName(name + OUT);
        outPort.setPort(this);
    }
    
    static final CANController valueOf(final String name) {
        return new CANController(name);
    }
    
    final InPort getInPort() {
        return this.inPort;
    }
    
    final OutPort getOutPort() {
        return this.outPort;
    }
}
