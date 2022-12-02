package Solid.products.food;

import Solid.products.Product;

public abstract class Food implements Product {

    private double CALORIES_PER_100_GRAMS;

    private double grams;



    public Food(double grams, double CALORIES_PER_100_GRAMS) {
        this.grams = grams;
        this.CALORIES_PER_100_GRAMS = CALORIES_PER_100_GRAMS;
    }

    public double getGrams() {
        return grams;
    }

    @Override
    public double getCalories() {
        return (CALORIES_PER_100_GRAMS / 100) * grams;
    }

    public double getKilograms(){
        return grams / 1000;
    }
}
