package org.networkcalculus.dnc.model.ethernet;

import org.networkcalculus.dnc.model.impl.FlowImpl;

public class VirtualLink extends FlowImpl {

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
}
