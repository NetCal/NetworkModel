package org.networkcalculus.dnc.model.ethernet;

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

    public final static VirtualLink valueOf(final String name, final double bag, final Priority priority, final int maxLength) {
        return new VirtualLink(name, bag, priority, maxLength);
    }

    public void setBag(final double bag) {
        this.setMinRetransmissionInterval(bag);
    }

    public double getBag() {
        return this.getMinRetransmissionInterval();
    }

    public void setVLPriority(final Priority priority) {
        this.setPriority(priority.intValue());
    }

    public Priority getVLPriority() {
        return Priority.valueOf(this.getPriority());
    }
    
    public final void addPath(PhysicalLink...links) {
        if (links == null) {
            return;
        }
        Path path = NetworkFactory.INSTANCE.createPath();
        for (var link : links) {
            path.getLinks().add(link);
        }
        this.getPaths().add(path);
    }
}
