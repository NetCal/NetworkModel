package org.networkcalculus.dnc.model.can;

import org.networkcalculus.dnc.model.InPort;
import org.networkcalculus.dnc.model.Link;
import org.networkcalculus.dnc.model.NetworkFactory;
import org.networkcalculus.dnc.model.Port;
import org.networkcalculus.dnc.model.impl.DeviceImpl;

/**
 * Class representing a Controller Area Network bus.
 * @author matyesz
 *
 */
public class CANBus extends DeviceImpl {
    
    private InPort inPort = NetworkFactory.INSTANCE.createInPort();
    
    private CANBus(final String name, final double bandwidth) {
        this.setName(name);
        this.createInPort();
    }
    
    private void createInPort() {
        final Port port = NetworkFactory.INSTANCE.createPort();
        this.inPort.setPort(port);
        this.inPort.setName(this.getName() + "IN");
    }
    
    /**
     * Static constructor
     * @param name the unique name of the bus
     * @param bandwidth the network speed in bps
     * @return {@link CANBus} the new object
     */
    public static final CANBus valueOf(final String name, final double bandwidth) {
        return new CANBus(name, bandwidth);
    }
    
    public final void addController(final CANController controller) {
        Link link = NetworkFactory.INSTANCE.createLink();
        link.setSrcPort(controller.getOutPort());
        link.getDstPorts().add(this.inPort);
    }
}
