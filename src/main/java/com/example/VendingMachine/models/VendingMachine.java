package com.example.VendingMachine.models;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    private List<Slot> slots;

    public VendingMachine() {
        // Initialize slots during the creation of the vending machine
        initializeSlots();
    }

    private void initializeSlots() {
        slots = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            String id = "s" + i;
            String itemCode = "s" + i;
            Slot slot = new Slot(id, itemCode);
            slots.add(slot);
        }


        System.out.println("Debug: Initialized Slots - " + slots);
        // Initialize slots for chips (type "m")
        for (int i = 1; i <= 10; i++) {
            String id = "m" + i;
            String itemCode = "m" + i;
            Slot slot = new Slot(id, itemCode);
            slots.add(slot);
        }
    }

    private void printSlotDetails() {
        System.out.println("Debug: Slot Details:");
        for (Slot slot : slots) {
            System.out.println("Debug: Slot ID: " + slot.getId() + ", Item Code: " + slot.getItemCode() + ", Available: " + slot.isAvailable());
        }
    }
    // Other methods and functionalities of your vending machine...
}
