package com.example.pharmacy_web.services;

import com.example.pharmacy_web.models.Product;
import com.example.pharmacy_web.models.Purchase;
import com.example.pharmacy_web.models.User;
import com.example.pharmacy_web.repositories.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PurchaseService {

    private final UserService userService;
    private final ProductService productService;
    private final PurchaseRepository purchaseRepository;

    public Purchase createPurchase(Long id, Principal principal){

        Purchase purchase= new Purchase();
        purchase.setUser(userService.getUserByPrincipal(principal));
        purchase.setProduct(productService.getProductById(id));
        purchase.setActivationCode(UUID.randomUUID().toString());
        purchase.setStatus("active");
        purchaseRepository.save(purchase);
        return purchase;
    }

}
