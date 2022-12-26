package EXAM.christmasPastryShop.core;

import static EXAM.christmasPastryShop.common.ExceptionMessages.*;

import static EXAM.christmasPastryShop.common.OutputMessages.*;

import EXAM.christmasPastryShop.core.interfaces.Controller;
import EXAM.christmasPastryShop.entities.booths.OpenBooth;
import EXAM.christmasPastryShop.entities.booths.PrivateBooth;
import EXAM.christmasPastryShop.entities.cocktails.Hibernation;
import EXAM.christmasPastryShop.entities.cocktails.MulledWine;
import EXAM.christmasPastryShop.entities.delicacies.Gingerbread;
import EXAM.christmasPastryShop.entities.delicacies.Stolen;
import EXAM.christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import EXAM.christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import EXAM.christmasPastryShop.entities.booths.interfaces.Booth;
import EXAM.christmasPastryShop.repositories.interfaces.BoothRepository;
import EXAM.christmasPastryShop.repositories.interfaces.CocktailRepository;
import EXAM.christmasPastryShop.repositories.interfaces.DelicacyRepository;

public class ControllerImpl implements Controller {

    private DelicacyRepository<Delicacy> delicacyRepository;

    private CocktailRepository<Cocktail> cocktailRepository;

    private BoothRepository<Booth> boothRepository;

    private double income;

    public ControllerImpl(DelicacyRepository<Delicacy> delicacyRepository, CocktailRepository<Cocktail> cocktailRepository, BoothRepository<Booth> boothRepository) {
        this.delicacyRepository = delicacyRepository;
        this.cocktailRepository = cocktailRepository;
        this.boothRepository = boothRepository;
    }


    @Override
    public String addDelicacy(String type, String name, double price) {
        if (delicacyRepository.getByName(name) != null) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }
        Delicacy delicacy = null;
        switch (type) {
            case "Gingerbread":
                delicacy = new Gingerbread(name, price);
                break;
            case "Stolen":
                delicacy = new Stolen(name, price);
                break;
        }
        delicacyRepository.add(delicacy);
        return String.format(DELICACY_ADDED, name, type);
    }

    @Override
    public String addCocktail(String type, String name, int size, String brand) {
        if (cocktailRepository.getByName(name) != null) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }
        Cocktail cocktail = null;
        switch (type) {
            case "Hibernation":
                cocktail = new Hibernation(name, size, brand);
                break;
            case "MulledWine":
                cocktail = new MulledWine(name, size, brand);
                break;
        }
        cocktailRepository.add(cocktail);
        return String.format(COCKTAIL_ADDED, name, brand);
    }

    @Override
    public String addBooth(String type, int boothNumber, int capacity) {
        if (boothRepository.getByNumber(boothNumber) != null) {
            throw new IllegalArgumentException(String.format(BOOTH_EXIST, boothNumber));
        }
        Booth booth = null;
        switch (type) {
            case "OpenBooth":
                booth = new OpenBooth(boothNumber, capacity);
                break;
            case "PrivateBooth":
                booth = new PrivateBooth(boothNumber, capacity);
                break;
        }
        boothRepository.add(booth);
        return String.format(BOOTH_ADDED, boothNumber);
    }

    @Override
    public String reserveBooth(int numberOfPeople) {
        Booth booth = null;

        for (Booth currentBooth : boothRepository.getAll()) {
            if (!currentBooth.isReserved() && currentBooth.getCapacity() >= numberOfPeople) {
                booth = currentBooth;
                break;
            }
        }

        if (booth == null) {
            return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
        } else {
            booth.reserve(numberOfPeople);
            return String.format(BOOTH_RESERVED, booth.getBoothNumber(), numberOfPeople);
        }

    }

    @Override
    public String leaveBooth(int boothNumber) {
        Booth booth = boothRepository.getByNumber(boothNumber);
        double boothIncome = booth.getBill() + booth.getPrice();

        booth.clear();


        income += boothIncome;
        return String.format(BILL, boothNumber, boothIncome);
    }

    @Override
    public String getIncome() {
        return String.format(TOTAL_INCOME, this.income);
    }
}
