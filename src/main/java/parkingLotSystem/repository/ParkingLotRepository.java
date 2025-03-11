package parkingLotSystem.repository;

import parkingLotSystem.model.Gate;
import parkingLotSystem.model.ParkingLot;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ParkingLotRepository {
    private final Map<Long, ParkingLot> parkingLotMap;
    public ParkingLotRepository() {
        parkingLotMap = new HashMap<>();
    }

    public ParkingLot save(ParkingLot parkingLot) {
        parkingLotMap.put(parkingLot.getId(), parkingLot);
        return parkingLot;
    }
    public Optional<ParkingLot> getParkingLotIdByGateId(long gateId) {
        for (ParkingLot parkingLot : parkingLotMap.values()) {
            for (Gate gate : parkingLot.getGates()) {
                if(gate.getId() == gateId){
                    return Optional.of(parkingLot);
                }
            }
        }
        return Optional.empty();
    }
}
