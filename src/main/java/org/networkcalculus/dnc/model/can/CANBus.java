package org.networkcalculus.dnc.model.can;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.networkcalculus.dnc.model.InPort;
import org.networkcalculus.dnc.model.Link;
import org.networkcalculus.dnc.model.NetworkFactory;
import org.networkcalculus.dnc.model.OutPort;
import org.networkcalculus.dnc.model.Path;
import org.networkcalculus.dnc.model.Port;
import org.networkcalculus.dnc.model.impl.NetworkImpl;

/**
 * Class representing a Controller Area Network bus.
 * @author matyesz
 *
 */
public class CANBus extends NetworkImpl {
    
    private final Port port = NetworkFactory.INSTANCE.createPort();
    private final InPort inPort = NetworkFactory.INSTANCE.createInPort();
    private final OutPort outPort = NetworkFactory.INSTANCE.createOutPort();
    private final Map<ECU, List<Link>> links = new HashMap<>();
    
    private CANBus(final String name, final double bandwidth) {
        this.setName(name);
        this.bandwidth = bandwidth;
        this.createInPort();
        this.createOutPort();
    }
    
    private void createInPort() {
        this.inPort.setPort(this.port);
        this.inPort.setName(this.getName() + "IN");
    }
    
    private void createOutPort() {
        this.outPort.setPort(this.port);
        this.outPort.setName(this.getName() + "OUT");
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
    
    /**
     * Connects an {@link ECU} to the {@link CANBus}
     * 
     * @param controller - the ECU
     */
    public final void connectECU(final CANController controller) {
        this.addController(controller);
    }
    
    private final void addController(final CANController controller) {
        final ECU ecu = (ECU)controller.getDevice();
        if (ecu == null) {
            throw new IllegalStateException("ECU is not assigned to controller");
        }
        if (links.containsKey(ecu)) {
            return;
        }
        Link inLink = NetworkFactory.INSTANCE.createLink();
        inLink.setSrcPort(controller.getOutPort());
        inLink.getDstPorts().add(this.inPort);
        Link outLink = NetworkFactory.INSTANCE.createLink();
        outLink.setSrcPort(this.outPort);
        outLink.getDstPorts().add(controller.getInPort());
        List<Link> ecuConnections = new ArrayList<>(2);
        ecuConnections.add(inLink);
        ecuConnections.add(outLink);
        this.links.put(ecu, ecuConnections);
    }
    
    /**
     * Adds a {@link CANFrame} to the {@link CANBus} with one publisher and several subscribers
     * even from other buses
     * @param name - the name of the frame must be unique within the bus
     * @param id - the id of the frame
     * @param source - the publisher
     * @param destinations - the list of subscribers
     * @return - the {@link CANFrame} instance
     */
    public final CANFrame addFrame(final String name, int id, final ECU source, final List<ECU> destinations) {
        if (destinations == null || destinations.isEmpty()) {
            throw new IllegalArgumentException("Destination cannot be null or empty");
        }
        if (this.containsFrame(id)) {
            throw new IllegalStateException("Frame with same id already exists on the bus");
        }
        final CANFrame frame = CANFrame.valueOf(name, id);
        final Link inLink = links.get(source).get(0);
        for (final var destination : destinations) {
            final Path path = NetworkFactory.INSTANCE.createPath();
            path.getLinks().add(inLink);
            path.getLinks().add(links.get(destination).get(1));
            frame.getPaths().add(path);
        }
        this.getFlows().add(frame);
        return frame;
    }
    
    private boolean containsFrame(final int id) {
        return this.getFlows().stream().filter(frame -> frame.getPriority() == id).count() == 1;
    }
    /**
     * Returns all frames transmitted on the given bus
     * @return {@link ArrayList} of frames or empty list
     */
    public final List<CANFrame> getFrames() {
        List<CANFrame> result = new ArrayList<>();
        for (final var flow : this.getFlows()) {
            result.add((CANFrame)flow);
        }
        return result;
    }
    
}
