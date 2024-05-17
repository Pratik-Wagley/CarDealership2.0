package pluralsight;

public class SalesContract extends Contract {
    private double salesTax;
    private double recordingFee;
    private double processingFee;
    private boolean finance;

    public SalesContract(String date, String name, Vehicle vehicle, double salesTax, double recordingFee, double processingFee, boolean finance) {
        super(date, name, vehicle);
        this.salesTax = getVehicle().getPrice() * .05;
        this.recordingFee = 100;
        if (getVehicle().getPrice() <= 10000) {
            this.processingFee = 295;
        } else {
            this.processingFee = 495;
        }
        this.finance = finance;
    }

    public double getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinance() {
        return finance;
    }

    public void setFinance(boolean finance) {
        this.finance = finance;
    }

    @Override
    public double getTotalPrice() {
        double total = 0;
        if (isFinance()) {
            if (getVehicle().getPrice() >= 10000) {
                total = (getMonthlyPrice() * 48) + getSalesTax() + getRecordingFee() + getProcessingFee();
            }
            else {
                total = (getMonthlyPrice() * 24) + getSalesTax() + getRecordingFee() + getProcessingFee();
            }
        }else {
            total = getVehicle().getPrice() + getSalesTax() + getRecordingFee() + getProcessingFee();
        }
        return total;
    }

    @Override
    public double getMonthlyPrice() {
        double price = 0;
        if (isFinance()) {
            if (getVehicle().getPrice() >= 10000) {
                price = getTotalPrice() / .0425;
            } else {
                price = getTotalPrice() / .0525;
            }
        }
        return price;
    }
}
