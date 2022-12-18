package ru.gb.internetshop.cart.integrations;

import api.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class ProductServiceIntegration {
    private final RestTemplate restTemplate;

    public ProductDto findById(Long id){
        return restTemplate.getForObject("http://localhost:8080/api/v1/products/"+id, ProductDto.class);
    }
}
