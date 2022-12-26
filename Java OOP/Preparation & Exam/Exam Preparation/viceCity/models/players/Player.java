package ExamPreparation.viceCity.models.players;

import ExamPreparation.viceCity.models.guns.Gun;
import ExamPreparation.viceCity.repositories.interfaces.Repository;

public interface Player {
    String getName();

    int getLifePoints();

    boolean isAlive();

    Repository<Gun> getGunRepository();

    void takeLifePoints(int points);
}
