package org.networkcalculus.dnc.model.ethernet.avb;

import org.networkcalculus.dnc.model.impl.ShaperImpl;

public class CreditBasedShaper extends ShaperImpl {

    private double sendSlopeA = 0.0;
    private double sendSlopeB = 0.0;
    private double idleSlopeA = 0.0;
    private double idleSlopeB = 0.0;
    private double maxCreditA = 0.0;
    private double maxCreditB = 0.0;

    private CreditBasedShaper(final double sendSlopeA, final double sendSlopeB, final double idleSlopeA,
	    final double idleSlopeB, final double maxCreditA, final double maxCreditB) {
	this.sendSlopeA = sendSlopeA;
	this.sendSlopeB = sendSlopeB;
	this.idleSlopeA = idleSlopeA;
	this.idleSlopeB = idleSlopeB;
	this.maxCreditA = maxCreditA;
	this.maxCreditB = maxCreditB;
    }

    public static CreditBasedShaper valueOf(final double sendSlopeA, final double sendSlopeB, final double idleSlopeA,
	    final double idleSlopeB, final double maxCreditA, final double maxCreditB) {
	return new CreditBasedShaper(sendSlopeA, sendSlopeB, idleSlopeA, idleSlopeB, maxCreditA, maxCreditB);
    }

    public double getSendSlopeA() {
	return sendSlopeA;
    }

    public double getSendSlopeB() {
	return sendSlopeB;
    }

    public double getIdleSlopeA() {
	return idleSlopeA;
    }

    public double getIdleSlopeB() {
	return idleSlopeB;
    }

    public double getMaxCreditA() {
	return maxCreditA;
    }

    public double getMaxCreditB() {
	return maxCreditB;
    }
}
