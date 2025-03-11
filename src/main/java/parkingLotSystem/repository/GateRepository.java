package parkingLotSystem.repository;

import parkingLotSystem.model.Gate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GateRepository {
    private final Map<Long, Gate> gateMap;
    public GateRepository() {
        gateMap = new HashMap<>();
    }

    public Gate save(Gate gate) {
        gateMap.put(gate.getId(), gate);
        return gate;
    }

    public Optional<Gate> getGateById(long id) {
        if(gateMap.containsKey(id)) {
            return Optional.ofNullable(gateMap.get(id));
        }
        return Optional.empty();
    }
}
