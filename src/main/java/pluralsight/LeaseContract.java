package pluralsight;

public class LeaseContract extends Contract{
    private double expectedEndingValue;
    private double leaseFee;
    private double monthlyPayment;

    public LeaseContract(String date, String name, Vehicle vehicle, double expectedEndingValue, double leaseFee, double monthlyPayment) {
        super(date, name, vehicle);
        this.expectedEndingValue = getVehicle().getPrice() * .5;
        this.leaseFee = getVehicle().getPrice() * .007;
        this.monthlyPayment = getVehicle().getPrice() * .04;
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
        return (getMonthlyPayment() * 36) + getLeaseFee();
    }

    @Override
    public double getMonthlyPrice() {
        return monthlyPayment;
    }
}
