package ExamPreparation.viceCity.repositories;

import ExamPreparation.viceCity.models.guns.Gun;
import ExamPreparation.viceCity.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;

public class GunRepository implements Repository<Gun> {

    private Collection<Gun> models;

    public GunRepository() {
        models = new ArrayList<>();
    }

    @Override
    public Collection<Gun> getModels() {
        return models;
    }

    @Override
    public void add(Gun gun) {
        if (!models.contains(gun)) {
            models.add(gun);
        }
    }

    @Override
    public boolean remove(Gun gun) {
        return models.remove(gun);
    }

    @Override
    public Gun find(String name) {
        return models.stream().filter(g -> g.getName().equals(name)).findFirst().orElse(null);
    }
}
