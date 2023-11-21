package com.example.VendingMachine.controllers;

import com.example.VendingMachine.models.Product;
import com.example.VendingMachine.models.Slot;
import com.example.VendingMachine.services.CustomerService;
import com.example.VendingMachine.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



    @RestController
    @RequestMapping("/api")
    public class VendingMachineController {

        private final List<Slot> slots; // Assuming you have a list of slots

        @Autowired
        public VendingMachineController(List<Slot> slots) {
            this.slots = slots;
        }

        @GetMapping("/list-available-products")
        public List<Product> listAvailableProducts() {
            return new CustomerService().listAvailableProducts(slots);
        }

        @PostMapping("/purchase-product")
        public void purchaseProduct(@RequestParam String slotId) {
            new CustomerService().purchaseProduct(slots, slotId);
        }

        @PostMapping("/load-product")
        public void loadProduct(@RequestBody Product product) {
            new OwnerService().loadProduct(slots, product);
        }

        // Other endpoints...

    }
