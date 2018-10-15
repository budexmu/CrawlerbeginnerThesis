package com.demet;

import java.util.List;

public class Product {

    private String title;
    private List<Offer> offers;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public String getTitle() {
        return title;
    }
}
