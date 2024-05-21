package pluralsight;

public abstract class Contract {
    private String date;
    private String name;
    private String email;
    private Vehicle vehicle;
    private double TotalPrice;
    private double monthlyPrice;

    public Contract(String date, String name,String email, Vehicle vehicle) {
        this.date = date;
        this.name = name;
        this.name = email;
        this.vehicle = vehicle;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public abstract double getTotalPrice();

    public abstract double getMonthlyPrice();
}
