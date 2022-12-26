package ExamPreparation.goldDigger.models.discoverer;

import ExamPreparation.goldDigger.models.museum.Museum;

public interface Discoverer {
    String getName();

    double getEnergy();

    boolean canDig();

    Museum getMuseum();

    void dig();
}
