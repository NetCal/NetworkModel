package org.networkcalculus.dnc.model.ethernet.avb;

import org.networkcalculus.dnc.model.FlowClass;
import org.networkcalculus.dnc.model.ethernet.VirtualLink;

public class AVBVirtualLink extends VirtualLink {

    private AVBVirtualLink(final String name, final double bag, final AVBClass avbClass, final int maxLength) {
	super(name, bag, maxLength, FlowClass.AVB);
	this.setAVBClass(avbClass);
    }

    /**
     * Static constructor
     * @param name the name of the VL
     * @param bag the retransmission rate of the VL in seconds
     * @param priority priority of the VL
     * @param maxLength the maximum packet length on the VL in bits
     * @return new {@link AVBVirtualLink} object
     */
    public final static AVBVirtualLink valueOf(final String name, final double bag, final AVBClass avbClass,
	    final int maxLength) {
	return new AVBVirtualLink(name, bag, avbClass, maxLength);
    }

    private void setAVBClass(AVBClass avbClass) {
	this.setPriority(avbClass.intValue());

    }

    public AVBClass getAVBClass() {
	return AVBClass.valueOf(this.getPriority());

    }

}
