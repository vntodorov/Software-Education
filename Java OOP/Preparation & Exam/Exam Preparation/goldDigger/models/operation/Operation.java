package ExamPreparation.goldDigger.models.operation;

import ExamPreparation.goldDigger.models.discoverer.Discoverer;
import ExamPreparation.goldDigger.models.spot.Spot;

import java.util.Collection;

public interface Operation {
    void startOperation(Spot spot, Collection<Discoverer> discoverers);

}
