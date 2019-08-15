package org.networkcalculus.dnc.model.ethernet;

public enum Priority {
    LOW(1), HIGH(0);
    
    private final int priority;

    private Priority(int priority) {
        this.priority = priority;
    }
    
    public final int intValue() {
        return this.priority;
    }
    
    public final static Priority valueOf(final int prioity) {
        switch(prioity) {
            case 0: return HIGH;
            case 1: return LOW;
            default: throw new IllegalStateException();
        }
    }
}
