package com.bridgelabz;

import java.util.HashMap;
import java.util.Map;

public class CabInvoiceMain {
    private static final double MIN_COST_PER_KM_FOR_NORMAL_RIDE = 10;
    private static final int COST_PER_TIME_FOR_NORMAL_RIDE = 1;
    private static final double MIN_FARE_FOR_NORMAL_RIDE = 5;
    public static final double MIN_COST_PER_KM_FOR_PREMIUM_RIDE = 15;
    public static final double COST_PER_TIME_FOR_PREMIUM_RIDE = 2;
    public static final double MIN_FARE_FOR_PREMIUM_RIDE = 20;

    public double calculateTotalFare(double distance, int time, String rideType) {
        if (rideType.equalsIgnoreCase("Normal Ride")) {
            double totalFare = distance * MIN_COST_PER_KM_FOR_NORMAL_RIDE + time * COST_PER_TIME_FOR_NORMAL_RIDE;
            return Math.max(totalFare, MIN_FARE_FOR_NORMAL_RIDE);
        } else if (rideType.equalsIgnoreCase("Premium")) {
            double totalFare = distance * MIN_COST_PER_KM_FOR_PREMIUM_RIDE + time * COST_PER_TIME_FOR_PREMIUM_RIDE;
            return Math.max(totalFare, MIN_FARE_FOR_PREMIUM_RIDE);
        } else {
            System.out.println("Please Enter Proper Customer Type");
            return 0.0;
        }
    }

    public double calculateFare(Ride[] ride1, String rideType) {
        double totalFare = 0.0;
        if (rideType.equalsIgnoreCase("Normal Ride")) {
            for (Ride ride : ride1) {
                totalFare = calculateTotalFare(ride.getDistance(), (int) ride.getTime(), rideType);
            }
            return totalFare;
        }else if(rideType.equalsIgnoreCase("Premium Ride"));
        for (Ride ride : ride1) {
            totalFare += calculateTotalFare(ride.getDistance(), (int) ride.getTime(), rideType);
        }
        return totalFare;
    }

    public InVoiceSummary calculateTotalFare(Ride[] ride1, String rideType) {
        double totalFare = 0.0;
        if (rideType.equalsIgnoreCase("Normal Ride")) {
            for (Ride ride : ride1) {
                totalFare += calculateTotalFare(ride.getDistance(), (int) ride.getTime(), rideType);
            }
        } else if (rideType.equalsIgnoreCase("Premium Ride")) {
            for (Ride ride : ride1) {
                totalFare += calculateTotalFare(ride.getDistance(), (int) ride.getTime(), rideType);
            }
        }
        return new InVoiceSummary(ride1.length, totalFare, rideType);
    }
}