package pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractDataManager {

    public void saveContract(Contract contract, Dealership dealership, int vin) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("contracts.csv"));
            if (contract instanceof SalesContract) {
                SalesContract salesContract = (SalesContract) contract;
                for (Vehicle vehicle : dealership.getAllVehicles()) {
                    if (vehicle.getVin() == vin) {
                        bw.write("SALE" + "|" + salesContract.getDate() + "|" + salesContract.getName()
                                + "|" + salesContract.getEmail() + "|" + vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" + vehicle.getModel()
                                + "|" + vehicle.getVehicleType() + "|" + vehicle.getColor() + "|" + vehicle.getOdometer()
                                + "|" + vehicle.getPrice() + "|" + salesContract.getSalesTax() + "|" + salesContract.getRecordingFee() + "|" + salesContract.getProcessingFee() + "|"
                                + salesContract.getTotalPrice() + "|" + salesContract.isFinance() + "|" + salesContract.getMonthlyPrice());
                    }
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}