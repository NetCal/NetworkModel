package org.networkcalculus.dnc.model.can;

/**
 * Enumeration of known CAN controller types
 * @author matyesz
 *
 */
public enum ECANControllerType {
    
    /**
     * CAN controller with priority inversion 
     */
    PI,
    
    /**
     * CAN controller with corrected PI, there can be one lower prio message due to queue 
     * reordering 
     */
    PPI,
    
    /**
     * CAN controller without priority inversion (correct behaviour) 
     */
    NON_PI;
    
}
