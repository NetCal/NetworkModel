package org.networkcalculus.dnc.model.ethernet.rc;

import org.networkcalculus.dnc.model.FlowClass;
import org.networkcalculus.dnc.model.ethernet.VirtualLink;

public class RCVirtualLink extends VirtualLink {

    private RCVirtualLink(final String name, final double bag, final Priority priority, final int maxLength) {
	super(name, bag, maxLength, FlowClass.RC);
	setVLPriority(priority);
    }

    /**
     * Static constructor
     * @param name the name of the VL
     * @param bag the retransmission rate of the VL in seconds
     * @param priority priority of the VL
     * @param maxLength the maximum packet length on the VL in bits
     * @return new {@link RCVirtualLink} object
     */
    public final static RCVirtualLink valueOf(final String name, final double bag, final Priority priority,
	    final int maxLength) {
        return new RCVirtualLink(name, bag, priority, maxLength);
    }

    protected void setVLPriority(final Priority priority) {
	this.setPriority(priority.intValue());
    }

    /**
     * The priority of the VL
     * 
     * @return {@link Priority} the prio
     */
    public Priority getVLPriority() {
	return Priority.valueOf(this.getPriority());
    }
}
