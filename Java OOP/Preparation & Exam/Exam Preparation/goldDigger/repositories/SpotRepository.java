package ExamPreparation.goldDigger.repositories;

import ExamPreparation.goldDigger.models.spot.Spot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SpotRepository implements Repository<Spot>{
    private Collection<Spot> spots;

    public SpotRepository(){
        spots = new ArrayList<>();
    }

    @Override
    public Collection<Spot> getCollection() {
        return Collections.unmodifiableCollection(spots);
    }

    @Override
    public void add(Spot entity) {
        spots.add(entity);
    }

    @Override
    public boolean remove(Spot entity) {
        return spots.remove(entity);
    }

    @Override
    public Spot byName(String name) {
        return spots.stream().filter(s -> s.getName().equals(name)).findFirst().orElse(null);
    }
}
