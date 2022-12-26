package ExamPreparation.goldDigger.models.operation;

import ExamPreparation.goldDigger.models.discoverer.Discoverer;
import ExamPreparation.goldDigger.models.spot.Spot;

import java.util.Collection;

public class OperationImpl implements Operation{


    @Override
    public void startOperation(Spot spot, Collection<Discoverer> discoverers) {
        Collection<String> spotExhibits = spot.getExhibits();

        for (Discoverer discoverer : discoverers){
            while (discoverer.canDig() && spotExhibits.iterator().hasNext()){
                discoverer.dig();

                String exhibit = spotExhibits.iterator().next();
                discoverer.getMuseum().getExhibits().add(exhibit);
                spotExhibits.remove(exhibit);
            }
        }

    }
}
