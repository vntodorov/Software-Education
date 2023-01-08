package com.bookshop.demo.domain.dto;

import com.bookshop.demo.domain.enums.AgeRestriction;
import com.bookshop.demo.domain.enums.EditionType;

import java.math.BigDecimal;

public class BookInformation {

    private String title;

    private EditionType editionType;

    private AgeRestriction ageRestriction;

    private BigDecimal price;

    public BookInformation(String title, EditionType editionType, AgeRestriction ageRestriction, BigDecimal price) {
        this.title = title;
        this.editionType = editionType;
        this.ageRestriction = ageRestriction;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public EditionType getEditionType() {
        return editionType;
    }

    public void setEditionType(EditionType editionType) {
        this.editionType = editionType;
    }

    public AgeRestriction getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(AgeRestriction ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return title + " " + editionType.name() + " " + ageRestriction.name() + " " + price;
    }
}
