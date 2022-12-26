package EXAM.christmasPastryShop.repositories;

import EXAM.christmasPastryShop.entities.booths.interfaces.Booth;
import EXAM.christmasPastryShop.repositories.interfaces.BoothRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BoothRepositoryImpl implements BoothRepository<Booth> {

    private Collection<Booth> models;

    public BoothRepositoryImpl() {
        models = new ArrayList<>();
    }

    @Override
    public Booth getByNumber(int number) {
        return models.stream().filter(b -> b.getBoothNumber() == number).findFirst().orElse(null);
    }

    @Override
    public Collection<Booth> getAll() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Booth booth) {
        models.add(booth);
    }
}
