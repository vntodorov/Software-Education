package ExamPreparation.fairyShop.repositories;

import ExamPreparation.fairyShop.models.Helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class HelperRepository implements Repository<Helper> {

    private Collection<Helper> helpers;

    public HelperRepository() {
        this.helpers = new ArrayList<>();
    }


    @Override
    public Collection<Helper> getModels() {
        return Collections.unmodifiableCollection(helpers);
    }

    @Override
    public void add(Helper helper) {
        helpers.add(helper);
    }

    @Override
    public boolean remove(Helper helper) {
        return helpers.remove(helper);
    }

    @Override
    public Helper findByName(String name) {
        return helpers.stream().filter(h -> h.getName().equals(name)).findFirst().orElse(null);
    }
}
