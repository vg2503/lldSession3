package parkingLotSystem.factory;

import parkingLotSystem.model.SpotAssignmentStrategyType;
import parkingLotSystem.strategies.CheapestSpotAssignmentStrategy;
import parkingLotSystem.strategies.FarthestSpotAssignmentStrategy;
import parkingLotSystem.strategies.NearestSpotAssignmentStrategy;
import parkingLotSystem.strategies.SpotAssignmentStrategy;

public class SpotAssignmentStrategyFactory {
    public static SpotAssignmentStrategy getSpotAssignmentStrategy(SpotAssignmentStrategyType strategy) {
        switch (strategy) {
            case NEAREST -> new NearestSpotAssignmentStrategy();
            case FARTHEST -> new FarthestSpotAssignmentStrategy();
            case CHEAPEST -> new CheapestSpotAssignmentStrategy();
        }
        return null;
    }
}
