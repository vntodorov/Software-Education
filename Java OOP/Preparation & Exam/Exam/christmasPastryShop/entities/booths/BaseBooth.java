package EXAM.christmasPastryShop.entities.booths;

import static EXAM.christmasPastryShop.common.ExceptionMessages.*;

import EXAM.christmasPastryShop.entities.booths.interfaces.Booth;
import EXAM.christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import EXAM.christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseBooth implements Booth {

    private Collection<Delicacy> delicacyOrders;

    private Collection<Cocktail> cocktailOrders;

    private int boothNumber;

    private int capacity;

    private int numberOfPeople;

    private double pricePerPerson;

    private boolean isReserved;

    private double price;

    protected BaseBooth(int boothNumber, int capacity, double pricePerPerson) {
        delicacyOrders = new ArrayList<>();
        cocktailOrders = new ArrayList<>();
        setBoothNumber(boothNumber);
        setCapacity(capacity);
        setPricePerPerson(pricePerPerson);
        isReserved = false;
    }

    protected void setPricePerPerson(double pricePerPerson) {
        this.pricePerPerson = pricePerPerson;
    }

    protected void setCapacity(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException(INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    protected void setBoothNumber(int boothNumber) {
        this.boothNumber = boothNumber;
    }

    @Override
    public int getBoothNumber() {
        return boothNumber;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public boolean isReserved() {
        return isReserved;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void reserve(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }

        this.numberOfPeople = numberOfPeople;
        isReserved = true;
        this.price = numberOfPeople * pricePerPerson;
    }

    @Override
    public double getBill() {
        return cocktailOrders.stream().mapToDouble(Cocktail::getPrice).sum() + delicacyOrders.stream().mapToDouble(Delicacy::getPrice).sum();
    }

    @Override
    public void clear() {
        cocktailOrders = new ArrayList<>();
        delicacyOrders = new ArrayList<>();
        isReserved = false;
        this.numberOfPeople = 0;
        this.price = 0;
    }
}
