package parkingLotSystem.repository;

import parkingLotSystem.model.Operator;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OperatorRepository {
    private final Map<Long, Operator> operatorMap;
    public OperatorRepository() {
        operatorMap = new HashMap<>();
    }

    public Operator save(Operator operator) {
        operatorMap.put(operator.getId(), operator);
        return operator;
    }

    public Optional<Operator> getOperatorById(long id) {
        if(operatorMap.containsKey(id)) {
            return Optional.ofNullable(operatorMap.get(id));
        }
        return Optional.empty();
    }
}
