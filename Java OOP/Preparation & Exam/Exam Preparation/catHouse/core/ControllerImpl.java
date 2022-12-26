package ExamPreparation.catHouse.core;

import static ExamPreparation.catHouse.common.ExceptionMessages.*;

import static ExamPreparation.catHouse.common.ConstantMessages.*;

import ExamPreparation.catHouse.entities.cat.Cat;
import ExamPreparation.catHouse.entities.cat.LonghairCat;
import ExamPreparation.catHouse.entities.cat.ShorthairCat;
import ExamPreparation.catHouse.entities.houses.House;
import ExamPreparation.catHouse.entities.houses.LongHouse;
import ExamPreparation.catHouse.entities.houses.ShortHouse;
import ExamPreparation.catHouse.entities.toys.Ball;
import ExamPreparation.catHouse.entities.toys.Mouse;
import ExamPreparation.catHouse.entities.toys.Toy;
import ExamPreparation.catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {

    private ToyRepository toys;

    private Collection<House> houses;

    public ControllerImpl() {
        toys = new ToyRepository();
        houses = new ArrayList<>();
    }

    @Override
    public String addHouse(String type, String name) {
        House house;
        switch (type) {
            case "ShortHouse":
                house = new ShortHouse(name);
                break;
            case "LongHouse":
                house = new LongHouse(name);
                break;
            default:
                throw new NullPointerException(INVALID_HOUSE_TYPE);
        }
        houses.add(house);
        return String.format(SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
    }

    @Override
    public String buyToy(String type) {
        Toy toy;
        switch (type) {
            case "Ball":
                toy = new Ball();
                break;
            case "Mouse":
                toy = new Mouse();
                break;
            default:
                throw new IllegalArgumentException(INVALID_TOY_TYPE);
        }
        toys.buyToy(toy);
        return String.format(SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        Toy toy = toys.findFirst(toyType);
        if (toy == null) {
            throw new IllegalArgumentException(String.format(NO_TOY_FOUND, toyType));
        }
        House house = findHouseByName(houseName);
        house.buyToy(toy);
        toys.removeToy(toy);
        return String.format(SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        Cat cat;
        switch (catType) {
            case "ShorthairCat":
                cat = new ShorthairCat(catName, catBreed, price);
                break;
            case "LonghairCat":
                cat = new LonghairCat(catName, catBreed, price);
                break;
            default:
                throw new IllegalArgumentException(INVALID_CAT_TYPE);
        }
        House house = findHouseByName(houseName);
        String currentHouseType = house.getClass().getSimpleName();

        if ((catType.equals("ShorthairCat") && currentHouseType.equals("ShortHouse"))
                || (catType.equals("LonghairCat")) && currentHouseType.equals("LongHouse")) {
            house.addCat(cat);
            return String.format(SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
        } else {
            return UNSUITABLE_HOUSE;
        }
    }

    @Override
    public String feedingCat(String houseName) {
        House house = findHouseByName(houseName);
        house.feeding();
        return String.format(FEEDING_CAT, house.getCats().size());
    }

    @Override
    public String sumOfAll(String houseName) {
        House house = findHouseByName(houseName);
        return String.format(VALUE_HOUSE, houseName, house.getCats().stream().mapToDouble(Cat::getPrice).sum() + house.getToys().stream().mapToDouble(Toy::getPrice).sum());
    }

    @Override
    public String getStatistics() {
        StringBuilder out = new StringBuilder();

        for (House house : houses) {
            out.append(house.getStatistics()).append(System.lineSeparator());
        }

        return out.toString().trim();
    }

    private House findHouseByName(String houseName) {
        return houses.stream().filter(h -> h.getName().equals(houseName)).findFirst().orElse(null);
    }
}
