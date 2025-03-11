package parkingLotSystem.repository;
import parkingLotSystem.model.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VehicleRepository {
    private final Map<String, Vehicle> vehicleMap;
    public VehicleRepository() {
        vehicleMap = new HashMap<>();
    }

    public Vehicle save(Vehicle vehicle) {
        vehicleMap.put(vehicle.getVehicleNumber(), vehicle);
        return vehicle;
    }

    public Optional<Vehicle> getVehicleById(String vehicleNumber) {
        if(vehicleMap.containsKey(vehicleNumber)) {
            return Optional.ofNullable(vehicleMap.get(vehicleNumber));
        }
        return Optional.empty();
    }
}
