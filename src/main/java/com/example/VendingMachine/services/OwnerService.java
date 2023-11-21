package com.example.VendingMachine.services;

import com.example.VendingMachine.models.Product;
import com.example.VendingMachine.models.Slot;

import java.util.List;
import java.util.Optional;

public class OwnerService {

    public void loadProduct(List<Slot> slots, Product product) {
        // Determine the slot type based on the product
        String slotType = determineSlotType(product);

        System.out.println("Product Type: " + slotType);

        // Print information about each slot for debugging
        System.out.println("Existing Slots:");
        for (Slot slot : slots) {
            System.out.println(slot);
        }

        // Find the first available slot of the specified type
        Optional<Slot> availableSlot = findAvailableSlot(slots, slotType);

        if (availableSlot.isPresent()) {
            Slot selectedSlot = availableSlot.get();
            System.out.println("Selected Slot ID: " + selectedSlot.getId());
            selectedSlot.setItemCode(generateItemCode(product.getName(), product.getType()));
            selectedSlot.setProduct(product);
            System.out.println("Product loaded successfully in slot: " + selectedSlot.getId());
        } else {
            System.out.println("No available slots for the product type: " + slotType);
        }
    }

    private String determineSlotType(Product product) {
        // Determine the slot type based on the product type
        // For example, if product.getType() is "cookie", return "s"; if "chips", return "m".
        String productType = product.getType().toLowerCase();
        System.out.println("Debug: Product Type: " + productType);  // Add this line for debugging
        if ("cookie".equals(productType)) {
            return "s";
        } else if ("chips".equals(productType)) {
            return "m";
        } else {
            // Add handling for other product types if needed
            System.out.println("Debug: Unknown Product Type");
            return "";
        }
    }

    private String generateItemCode(String name, String type) {
        // Handle empty or null product name
        if (name == null || name.isEmpty()) {
            // You might want to add more sophisticated logic here based on your requirements
            return type.toLowerCase() + "default";
        }

        // Logic to generate itemCode based on name and type
        // For example, concatenate the first letter of the name with the type
        return name.substring(0, 1).toLowerCase() + type.toLowerCase();
    }

    private String generateSlotId(List<Slot> slots, String type) {
        // Count the number of existing slots of the given type
        long count = slots.stream()
                .filter(slot -> slot.getItemCode().startsWith(type))
                .count();

        // Increment the count by 1 to generate the next available slot ID
        return type.toLowerCase() + (count + 1);
    }

    private Optional<Slot> findAvailableSlot(List<Slot> slots, String slotType) {
        System.out.println("Debug: Searching for slotType: " + slotType);
        notifyAll(); // Print slot details for additional confirmation

        Optional<Slot> availableSlot = slots.stream()
                .filter(slot -> slot.getItemCode() != null && slot.getItemCode().startsWith(slotType) && slot.isAvailable())
                .findFirst();

        if (availableSlot.isPresent()) {
            System.out.println("Debug: Found an available slot!");
            return availableSlot;
        } else {
            System.out.println("Debug: No available slot found for slotType: " + slotType);
            return Optional.empty();
        }
    }
}

