package ru.gb.internetshop.core.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.internetshop.core.integrations.CartServiceIntegration;
import ru.gb.internetshop.core.services.OrderService;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrdersController {
    private final OrderService orderService;
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewOrder(Principal principal){
        String username=principal.getName();
        orderService.createOrder(username);
    }
}
