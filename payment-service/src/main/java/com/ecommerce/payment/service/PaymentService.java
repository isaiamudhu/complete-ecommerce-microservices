
package com.ecommerce.payment.service;

import com.ecommerce.payment.entity.Payment;
import com.ecommerce.payment.repository.PaymentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository repository;

    public PaymentService(PaymentRepository repository) {
        this.repository = repository;
    }

    public Payment save(Payment obj) {
        return repository.save(obj);
    }

    public List<Payment> getAll() {
        return repository.findAll();
    }

    public Payment getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
