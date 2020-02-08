package org.networkcalculus.dnc.model.ethernet.rc;

/**
 * Class representing the Priorities for VLs
 * @author matyesz
 *
 */
public enum Priority {
    LOW(1), HIGH(0);
    
    private final int priority;

    private Priority(int priority) {
        this.priority = priority;
    }
    
    /**
     * Converts priority into an integer. 0 is the highest prio.
     * @return the int representaion of the priority
     */
    public final int intValue() {
        return this.priority;
    }
    
    /**
     * Converts integer into priority
     * @param prioity int representation of prio.
     * @return HIGH of 0, LOW for all other values
     */
    public final static Priority valueOf(final int prioity) {
        switch(prioity) {
            case 0: return HIGH;
            case 1: return LOW;
            default: return LOW;
        }
    }
}
