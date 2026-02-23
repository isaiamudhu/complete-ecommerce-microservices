
package com.ecommerce.payment.controller;

import com.ecommerce.payment.entity.Payment;
import com.ecommerce.payment.service.PaymentService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @PostMapping
    public Payment save(@RequestBody Payment obj) {
        return service.save(obj);
    }

    @GetMapping
    public List<Payment> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Payment getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
