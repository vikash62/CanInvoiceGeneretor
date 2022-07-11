package com.bridgelabz;

public class Ride {
    public final double distance;
    public final int time;
    public double getDistance;
    public int getTime;

    public Ride(double distance, int time) {
        this.distance=distance;
        this.time=time;
    }

    public double getDistance() {
        return distance;
    }

    public double getTime() {
        return time;
    }
}