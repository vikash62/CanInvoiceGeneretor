package com.bridgelabz;

import java.util.Objects;

public class InVoiceSummary {
    int numberOfRides;
    double totalFare;
    double avgFare;

    public InVoiceSummary() {
    }

    public InVoiceSummary(int numberOfRides, double totalFare, String rideType) {
        this.numberOfRides = numberOfRides;
        this.totalFare = totalFare;
    }

    public InVoiceSummary(int numberOfRides, double totalFare) {
    }

    public InVoiceSummary getInvoiceSummary() {
        this.avgFare = this.totalFare / this.numberOfRides;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InVoiceSummary that = (InVoiceSummary) o;
        return numberOfRides == that.numberOfRides && Double.compare(that.totalFare, totalFare) == 0 && Double.compare(that.avgFare, avgFare) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfRides, totalFare, avgFare);
    }

}