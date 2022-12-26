package ExamPreparation.viceCity.models.players;

import static ExamPreparation.viceCity.common.ExceptionMessages.*;

import ExamPreparation.viceCity.models.guns.Gun;
import ExamPreparation.viceCity.repositories.GunRepository;
import ExamPreparation.viceCity.repositories.interfaces.Repository;

public abstract class BasePlayer implements Player {

    private String name;

    private int lifePoints;

    private Repository<Gun> gunRepository;

    protected BasePlayer(String name, int lifePoints) {
        setName(name);
        setLifePoints(lifePoints);
        this.gunRepository = new GunRepository();
    }

    protected void setLifePoints(int lifePoints) {
        if (lifePoints < 0) {
            throw new IllegalArgumentException(PLAYER_LIFE_POINTS_LESS_THAN_ZERO);
        }
        this.lifePoints = lifePoints;
    }

    protected void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(PLAYER_NULL_USERNAME);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getLifePoints() {
        return lifePoints;
    }

    @Override
    public boolean isAlive() {
        return lifePoints > 0;
    }

    @Override
    public Repository<Gun> getGunRepository() {
        return gunRepository;
    }

    @Override
    public void takeLifePoints(int points) {
        lifePoints -= points;
        if (lifePoints < 0) {
            lifePoints = 0;
        }
    }
}
