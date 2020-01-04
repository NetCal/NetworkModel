package org.networkcalculus.dnc.model.ethernet;

import java.util.ArrayList;
import java.util.List;

import org.networkcalculus.dnc.model.NetworkFactory;
import org.networkcalculus.dnc.model.Path;
import org.networkcalculus.dnc.model.impl.FlowImpl;

public class VirtualLink extends FlowImpl {

    private VirtualLink(final String name, final double bag, final Priority priority, final int maxLength) {
        this.setName(name);
        this.setBag(bag);
        this.setVLPriority(priority);
        this.setMaxLenght(maxLength);
    }

    /**
     * Static constructor
     * @param name the name of the VL
     * @param bag the retransmission rate of the VL in seconds
     * @param priority priority of the VL
     * @param maxLength the maximum packet length on the VL in bits
     * @return new {@link VirtualLink} object
     */
    final static VirtualLink valueOf(final String name, final double bag, final Priority priority, final int maxLength) {
        return new VirtualLink(name, bag, priority, maxLength);
    }

    private void setBag(final double bag) {
        this.setMinRetransmissionInterval(bag);
    }

    /**
     * The bag value.
     * @return the bag value in seconds
     */
    public double getBag() {
        return this.getMinRetransmissionInterval();
    }

    private void setVLPriority(final Priority priority) {
        this.setPriority(priority.intValue());
    }

    /**
     * The priority of the VL
     * @return {@link Priority} the prio
     */
    public Priority getVLPriority() {
        return Priority.valueOf(this.getPriority());
    }
    
    /**
     * Adds a full path to VL
     * @param links the {@link List} of all {@link Link} belonging to path  
     */
    public final void addPath(PhysicalLink...links) {
        if (links == null) {
            return;
        }
        Path path = NetworkFactory.INSTANCE.createPath();
        for (var link : links) {
            path.getLinks().add(link);
            ((NetworkInterface)link.getSrcPort().getPort()).addVirtualLink(this);
        }
        this.getPaths().add(path);
    }
    
    /**
     * All paths for the VL
     * @return a {@link List} of all paths of the VL within the network
     */
    public List<List<PhysicalLink>> getVLPaths() {
        List<List<PhysicalLink>> result = new ArrayList<List<PhysicalLink>>();
        for (final var path : getPaths()) {
            List<PhysicalLink> links = new ArrayList<PhysicalLink>();
            for (final var link : path.getLinks()) {
                links.add((PhysicalLink)link);
            }
            result.add(links);
        }
        return result;
    }
    
    public String toString() {
        final StringBuilder result = new StringBuilder();
        result.append(this.getName());
        result.append("\n");
        for (final var path : this.getPaths()) {
            for (final var link : path.getLinks()) {
                result.append(link.getSrcPort().getPort().getDevice().getName());
                result.append("(" + link.getSrcPort().getName() + ")");
                result.append(" - ");
            }
            result.delete(result.length() - 3, result.length());
            result.append("\n");
        }
        return result.toString();
    }
}
