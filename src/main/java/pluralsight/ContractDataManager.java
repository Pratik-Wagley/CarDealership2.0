package pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ContractDataManager {

    public void saveContract(Contract contract, Dealership dealership, int vin) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("contracts.csv"));
            if (contract instanceof SalesContract) {
                List<Vehicle> allVehicles = dealership.getAllVehicles();
                for (int i = allVehicles.size() - 1; i >= 0; i--) {
                    Vehicle vehicle = allVehicles.get(i);
                    if (vehicle.getVin() == vin) {
                        SalesContract salesContract = (SalesContract) contract;
                        bw.write("SALE" + "|" + salesContract.getDate() + "|" + salesContract.getName()
                                + "|" + salesContract.getEmail() + "|" + vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" + vehicle.getModel()
                                + "|" + vehicle.getVehicleType() + "|" + vehicle.getColor() + "|" + vehicle.getOdometer()
                                + "|" + vehicle.getPrice() + "|" + salesContract.getSalesTax() + "|" + salesContract.getRecordingFee() + "|" + salesContract.getProcessingFee() + "|"
                                + salesContract.getTotalPrice() + "|" + salesContract.isFinance() + "|" + salesContract.getMonthlyPrice());
                    }
                    dealership.removeVehicle(vehicle);
                }

            } else if (contract instanceof LeaseContract) {
                LeaseContract leaseContract = (LeaseContract) contract;
                List<Vehicle> allVehicles = dealership.getAllVehicles();
                for (int i = allVehicles.size() - 1; i >= 0; i--) {
                    Vehicle vehicle = allVehicles.get(i);
                    if (vehicle.getVin() == vin) {
                        bw.write("LEASE" + "|" + leaseContract.getDate() + "|" + leaseContract.getName()
                                + "|" + leaseContract.getEmail() + "|" + vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" + vehicle.getModel()
                                + "|" + vehicle.getVehicleType() + "|" + vehicle.getColor() + "|" + vehicle.getOdometer()
                                + "|" + vehicle.getPrice() + "|" + leaseContract.getExpectedEndingValue() + "|" + leaseContract.getLeaseFee() + "|" + leaseContract.getTotalPrice() + "|"
                                + leaseContract.getMonthlyPayment());
                    }
                    dealership.removeVehicle(vehicle);

                }
            }
            bw.newLine();
            bw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}