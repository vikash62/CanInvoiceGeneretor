package com.bridgelabz;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class InvoiceGeneratorTest {
    CabInvoiceMain inVoiceGenerator;

    @Before
    public void before(){
        inVoiceGenerator = new CabInvoiceMain();
    }

    @Test
    public void givenDistanceAndTime_WhenNormal_ShouldReturnTotalFare() {

        double distance = 2.0;
        int time = 5;
        String rideType = "normal Ride";
        double fare = inVoiceGenerator.calculateTotalFare(distance, time, rideType);
        Assert.assertEquals(25, fare, 0.0);

    }

    @Test
    public void givenLessDistanceAndTime_WhenNormal_ShouldReturnMinFare() {
        double distance = 0.1;
        int time = 1;
        String rideType = "normal Ride";
        double fare = inVoiceGenerator.calculateTotalFare(distance, time, rideType);
        Assert.assertEquals(5, fare, 0.0);
    }

    @Test
    public void givenMultipleRides_WhenNormal_ShouldReturnTotalFare() {

        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)};
        String rideType = "normal Ride";
        double totalFare = inVoiceGenerator.calculateFare(rides, rideType);
        Assert.assertEquals(30.0, totalFare, 0.0);
    }


    @Test
    public void givenDistanceAndTime_WhenPremium_ShouldReturnTotalFare() {

        double distance = 2.0;
        int time = 5;
        String rideType = "premium Ride";
        double fare = inVoiceGenerator.calculateTotalFare(distance, time, rideType);
        Assert.assertEquals(40, fare, 0.0);

    }

    @Test
    public void givenLessDistanceAndTime_WhenPremium_ShouldReturnMinFare() {

        double distance = 0.1;
        int time = 1;
        String rideType = "premium Ride";
        double fare = inVoiceGenerator.calculateTotalFare(distance, time, rideType);
        Assert.assertEquals(20, fare, 0.0);
    }

    @Test
    public void givenMultipleRides_WhenPremiumRide_ShouldReturnTotalFare() {

        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)};
        String type = "premium Ride";
        double totalFare = inVoiceGenerator.calculateFare(rides, type);
        Assert.assertEquals(60, totalFare, 0.0);
    }

    @Test
    public void givenMultipleRides_WhenNormalRide_ShouldReturnInvoiceSummary() {
        String rideType = "Normal Ride";
        Ride[] ride1 = {new Ride(2.0, 5),
                new Ride(0.1, 1),
        };
        InVoiceSummary inVoiceSummary = inVoiceGenerator.calculateTotalFare(ride1, rideType);
        InVoiceSummary expectedInvoices = new InVoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoices.getInvoiceSummary(), inVoiceSummary.getInvoiceSummary());
    }

    @Test
    public void givenMultipleRides_WhenPremiumRide_ShouldReturnInvoiceSummary() {
        String rideType = "Premium Ride";
        Ride[] ride1 = {new Ride(2.0, 5),
                new Ride(0.1, 1),
        };
        InVoiceSummary invoiceSummary = inVoiceGenerator.calculateTotalFare(ride1, rideType);
        InVoiceSummary expectedInvoices = new InVoiceSummary(2, 60.0);
        Assert.assertEquals(expectedInvoices.getInvoiceSummary(), invoiceSummary.getInvoiceSummary());
    }
}