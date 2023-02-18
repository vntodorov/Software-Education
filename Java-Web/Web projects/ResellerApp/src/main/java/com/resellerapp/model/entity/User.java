package com.resellerapp.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Offer> offers;

    @OneToMany
    private List<Offer> boughtOffers;

    public User() {
        offers = new ArrayList<>();
        boughtOffers = new ArrayList<>();
    }

    public void addOffer(Offer offer) {
        this.offers.add(offer);
    }

    public void removeOffer(Offer offer){
        this.offers.remove(offer);
    }

    public void addBoughtOffer(Offer offer) {
        this.boughtOffers.add(offer);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    public List<Offer> getBoughtOffers() {
        return boughtOffers;
    }

    public void setBoughtOffers(List<Offer> boughtOffers) {
        this.boughtOffers = boughtOffers;
    }
}
