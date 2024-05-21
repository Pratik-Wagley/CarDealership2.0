package pluralsight;

public class LeaseContract extends Contract{
    private double expectedEndingValue;
    private double leaseFee;
    private double monthlyPayment;

    public LeaseContract(String date, String name, String email, Vehicle vehicle) {
        super(date, name, email, vehicle);
        this.expectedEndingValue = getVehicle().getPrice() * .5;
        this.leaseFee = getVehicle().getPrice() * .007;
        this.monthlyPayment = getVehicle().getPrice() * .04;git
    }

    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }
    @Override
    public double getTotalPrice() {
        return (getVehicle().getPrice() - expectedEndingValue) + leaseFee;

    }

    @Override
    public double getMonthlyPrice() {
        int numberOfPayments = 36;
        double interestRate = 4.0 / 1200;
        double monthlyPayment = getTotalPrice() * (interestRate * Math.pow(1 + interestRate, numberOfPayments)) / (Math.pow(1 + interestRate, numberOfPayments) - 1);
        monthlyPayment = Math.round(monthlyPayment * 100);
        monthlyPayment /= 100;
        return monthlyPayment;
    }
}
