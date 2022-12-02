package Solid.products.drink;

import Solid.products.Product;

public abstract class Drink implements Product {
    private double CALORIES_PER_100_GRAMS;
    private double DENSITY;
    private double milliliters;

    public Drink(double milliliters, double CALORIES_PER_100_GRAMS, double DENSITY) {
        this.milliliters = milliliters;
        this.CALORIES_PER_100_GRAMS = CALORIES_PER_100_GRAMS;
        this.DENSITY = DENSITY;
    }

    public double getMilliliters() {
        return milliliters;
    }

    @Override
    public double getCalories() {
        double grams = getMilliliters() * DENSITY;
        return (CALORIES_PER_100_GRAMS / 100) * grams;

    }

    public double getLiters(){
        return milliliters * 1000;
    }

    @Override
    public double getKilograms(){
        return getLiters() * DENSITY;
    }

}
