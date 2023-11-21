package com.example.VendingMachine.services;

import com.example.VendingMachine.models.Product;
import com.example.VendingMachine.models.Slot;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CustomerService {

    public List<Product> listAvailableProducts(List<Slot> slots) {
        return slots.stream()
                .filter(slot -> slot.getProduct() != null)
                .map(Slot::getProduct)
                .collect(Collectors.toList());
    }

    public void purchaseProduct(List<Slot> slots, String slotId) {
        Optional<Slot> selectedSlot = findSlotById(slots, slotId);

        if (selectedSlot.isPresent()) {
            Slot slot = selectedSlot.get();

            // Perform the purchase logic, e.g., deducting payment, updating inventory, etc.

            // Mark the slot as available after the purchase
            slot.setProduct(null);

            System.out.println("Purchase successful for product in slot: " + slotId);
        } else {
            System.out.println("Invalid slot ID or the product is not available for purchase.");
        }
    }

    private Optional<Slot> findSlotById(List<Slot> slots, String slotId) {
        return slots.stream()
                .filter(slot -> slot.getId().equals(slotId))
                .findFirst();
    }
}
