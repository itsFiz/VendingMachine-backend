package com.example.VendingMachine.models;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id

    private String name;
    private String type; // "S" for small, "M" for medium


    public Product(Long id, String name, String type, String itemCode) {

        this.name = name;
        this.type = type;

    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }
    // Constructors, getters, and setters...

    public String getType() {
        return type;
    }


}
