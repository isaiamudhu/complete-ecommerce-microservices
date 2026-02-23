
package com.ecommerce.inventory.controller;

import com.ecommerce.inventory.entity.Inventory;
import com.ecommerce.inventory.service.InventoryService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/inventorys")
public class InventoryController {

    private final InventoryService service;

    public InventoryController(InventoryService service) {
        this.service = service;
    }

    @PostMapping
    public Inventory save(@RequestBody Inventory obj) {
        return service.save(obj);
    }

    @GetMapping
    public List<Inventory> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Inventory getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
