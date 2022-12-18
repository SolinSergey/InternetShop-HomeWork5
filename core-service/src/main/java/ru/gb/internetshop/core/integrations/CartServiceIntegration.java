package ru.gb.internetshop.core.integrations;

import api.CartDto;
import api.ProductDto;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class CartServiceIntegration {
    private final RestTemplate restTemplate;

    public CartDto getCurrentCart(){
        return restTemplate.getForObject("http://localhost:8081/market/api/v1/cart/", CartDto.class);
    }

    public void clearCart(){
        restTemplate.getForObject("http://localhost:8081/market/api/v1/cart/clear", ResponseEntity.class);
    }
}
