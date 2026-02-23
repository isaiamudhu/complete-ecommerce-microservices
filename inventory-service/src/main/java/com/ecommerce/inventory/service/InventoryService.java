
package com.ecommerce.inventory.service;

import com.ecommerce.inventory.entity.Inventory;
import com.ecommerce.inventory.repository.InventoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InventoryService {

    private final InventoryRepository repository;

    public InventoryService(InventoryRepository repository) {
        this.repository = repository;
    }

    public Inventory save(Inventory obj) {
        return repository.save(obj);
    }

    public List<Inventory> getAll() {
        return repository.findAll();
    }

    public Inventory getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
