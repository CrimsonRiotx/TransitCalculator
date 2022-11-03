import java.util.Scanner;

public class TransitCalculator {
    //Attributes
    int days;
    int rides;

    //Constructor
    public TransitCalculator(int days, int rides) {
        this.days = days;
        this.rides = rides;
    }

    String[] NYCFareOptions = {"Pay-per-Ride", "7-day Unlimited Rides", "30-day Unlimited Rides"};
    double[] NYCFarePrices = {2.75, 33.00, 127.00};

    public double unlimited7Price() {
        double numberOfWeeks;
        if (days % 7 != 0) {
            numberOfWeeks = (days / 7) + 1;
        } else numberOfWeeks = (days / 7);
        double totalCost = numberOfWeeks * NYCFarePrices[1];
        return totalCost / rides;
    }

    public double[] getRidePrices() {
        //creating array for ridePrices
        double[] ridePrices = new double[3];
        double dailyPrice = 2.75;
        ridePrices[0] = dailyPrice;
        ridePrices[1] = unlimited7Price();
        double monthlyPrice = NYCFarePrices[2] / rides;
        ridePrices[2] = monthlyPrice;
        return ridePrices;
    }

    public String getBestFare() {
        double[] ridePrices = getRidePrices();
        String bestFare;
        if (ridePrices[0] < ridePrices[1] && ridePrices[0] < ridePrices[2]) {
            bestFare = ("You should get the " + NYCFareOptions[0] + " option at $" + ridePrices[0] + " per ride.");
        } else if (ridePrices[1] < ridePrices[2] && ridePrices[1] < ridePrices[0]) {
            bestFare = ("You should get the " + NYCFareOptions[1] + " option at $" + ridePrices[1] + " per ride.");
        } else {
            bestFare = ("You should get the " + NYCFareOptions[2] + " option at $" + ridePrices[2] + " per ride.");
        }
        return bestFare;
    }

    //main method
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the total number of days you are visiting NYC:");
        int days = input.nextInt();
        System.out.println("Please enter how many times you plan to use public transit:");
        int rides = input.nextInt();
        TransitCalculator transitCalculator = new TransitCalculator(days, rides);
        System.out.println(transitCalculator.getBestFare());
        System.out.println("\nThank you for using my tool. Have a great day!");
    }
}
