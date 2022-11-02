public class TransitCalculator {
    //Attributes
    int days;
    int rides;

    //Constructor
    public TransitCalculator(int days, int rides){
        this.days = days;
        this.rides = rides;
    }

    String[] NYCFareOptions = {"Pay-per-Ride", "7-day Unlimited Rides", "30-day Unlimited Rides"};
    double[] NYCFarePrices = {2.75, 33.00, 127.00};

    public double unlimited7Price(){
        double numberOfWeeks;
        if(days%7!=0){
            numberOfWeeks = (days/7) + 1;
        } else numberOfWeeks = (days/7);
        double totalCost = numberOfWeeks*NYCFarePrices[1];
        double pricePerRide = totalCost / rides;
        return pricePerRide;
    }

    public double[] getRidePrices(){
        //creating array for ridePrices
        double[] ridePrices = new double[3];
        double dailyPrice = rides * NYCFarePrices[0];
        ridePrices[0] = dailyPrice;
        ridePrices[1] = unlimited7Price();
        double monthlyPrice = NYCFarePrices[2]/rides;
        ridePrices[2] = monthlyPrice;
        return ridePrices;
    }

    //main method
    public static void main(String[] args){

    }
}
