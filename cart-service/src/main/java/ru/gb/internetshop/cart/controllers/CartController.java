package ru.gb.internetshop.cart.controllers;

import api.CartDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.internetshop.cart.converters.CartConverter;
import ru.gb.internetshop.cart.service.CartService;


@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CartController {
    private final CartService cartService;
    private final CartConverter cartConverter;

    @CrossOrigin("*")
    @GetMapping("/add/{productId}")
    public void addProductToCart(@PathVariable Long productId){
        cartService.addToCart(productId);
    }

    @CrossOrigin("*")
    @GetMapping("/sub/{productId}")
    public void subProductFromCurrentCart(@PathVariable Long productId){
        cartService.subToCart(productId);
    }

    @CrossOrigin("*")
    @DeleteMapping("/remove/{id}")
    public void removeItem(@PathVariable Long id) {
        cartService.removeItem(id);
    }
    @CrossOrigin("*")
    @GetMapping
    public CartDto getCurrentCart(){
        return cartConverter.entityToCartDto(cartService.getCurrentCart());
    }

    @CrossOrigin("*")
    @GetMapping("/clear")
    public void clearCart(){
        cartService.clearCart();
    }
}
