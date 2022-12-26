package EXAM.christmasPastryShop.repositories;

import EXAM.christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import EXAM.christmasPastryShop.repositories.interfaces.CocktailRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CocktailRepositoryImpl implements CocktailRepository<Cocktail> {

    private Collection<Cocktail> models;

    public CocktailRepositoryImpl(){
        models = new ArrayList<>();
    }

    @Override
    public Cocktail getByName(String name) {
        return models.stream().filter(c -> c.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Collection<Cocktail> getAll() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Cocktail cocktail) {
        models.add(cocktail);
    }
}
