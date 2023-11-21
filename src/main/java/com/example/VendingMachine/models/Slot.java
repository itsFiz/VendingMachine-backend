package com.example.VendingMachine.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Slot {

    @Id
    private String id; // e.g., s1, s2, m1, m2

    private String itemCode; // e.g., s1, s2, m1, m2

    @OneToOne
    private Product product;

    private boolean available;

    public Slot() {
        // Default constructor for JPA
    }

    public Slot(String id, String itemCode) {
        this.id = id;
        this.itemCode = itemCode;
        this.available = true;  // Explicitly set availability
    }

    // Other attributes, getters, and setters...

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getId() {
        return id;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
        this.available = (product == null);
    }


}
