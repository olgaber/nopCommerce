package com.provectus.entities;

public class Product {
    private String title;
    private Double price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductCard{" +
                "title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
