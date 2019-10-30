package org.networkcalculus.dnc.model.can;

import org.networkcalculus.dnc.model.InPort;
import org.networkcalculus.dnc.model.NetworkFactory;
import org.networkcalculus.dnc.model.OutPort;
import org.networkcalculus.dnc.model.impl.PortImpl;

//TODO - add controller properties
/**
 * The class representing the CAN controller
 * @author matyesz
 *
 */
public class CANController extends PortImpl {
    
    private static final String OUT = "OUT";
    private static final String IN = "IN";
    
    private InPort inPort = NetworkFactory.INSTANCE.createInPort();
    private OutPort outPort = NetworkFactory.INSTANCE.createOutPort();
    private ECANControllerType type = ECANControllerType.PI;
    
    private CANController(final String name, final ECANControllerType type) {
        inPort.setName(name + IN);
        inPort.setPort(this);
        outPort.setName(name + OUT);
        outPort.setPort(this);
        this.type  = type;
    }
    
    /**
     * Static constructor
     * @param name - the name of the controller
     * @return the {@link CANController} instance
     */
    static final CANController valueOf(final String name, final ECANControllerType type) {
        return new CANController(name, type);
    }
    
    /**
     * Returns the input port of the {@link CANController}
     * @return the {@link InPort} instance
     */
    final InPort getInPort() {
        return this.inPort;
    }
    
    /**
     Returns the output port of the {@link CANController}
     * @return the {@link OutPort} instance
     */
    final OutPort getOutPort() {
        return this.outPort;
    }
    
    /**
     * Returns controller behaviour
     * @return {@link ECANControllerType} the behaviour
     */
    final public ECANControllerType getType() {
        return this.type;
    }
}
