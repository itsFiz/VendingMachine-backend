package com.example.VendingMachine.models;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SlotRepo extends CrudRepository<Slot, Long> {
    List<Slot>findByAvailableTrue();
}
