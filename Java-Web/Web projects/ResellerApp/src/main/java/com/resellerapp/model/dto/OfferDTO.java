package com.resellerapp.model.dto;

import com.resellerapp.model.entity.Offer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class OfferDTO {

    @Positive
    private Long id;

    @NotBlank
    @Size(min = 2, max = 50)
    private String description;

    @Positive
    private BigDecimal price;

    @NotBlank
    private String condition;

    public OfferDTO(Offer offer) {
        this.id = offer.getId();
        this.description = offer.getDescription();
        this.price = offer.getPrice();
        this.condition = offer.getCondition().getName().name();
    }

    public String getDescription() {
        return description;
    }

    public OfferDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
