package parkingLotSystem.strategies;

import parkingLotSystem.model.ParkingLot;
import parkingLotSystem.model.ParkingSpot;
import parkingLotSystem.model.VehicleType;

public interface SpotAssignmentStrategy {
    public ParkingSpot assignSpot(VehicleType vehicleType, ParkingLot parkingLot);
}
