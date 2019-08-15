package org.networkcalculus.dnc.model.ethernet;

import org.networkcalculus.dnc.model.impl.FlowImpl;

public class VirtualLink extends FlowImpl {

    public void setBag(final double bag) {
        this.setMinRetransmissionInterval(bag);
    }
    
    public double getBag() {
        return this.getMinRetransmissionInterval();
    }
    
    public void setPriority(final Priority priority) {
        
    }
    
    public Priority getPriority() {
        return Priority.valueOf("HIGH");
    }
}
