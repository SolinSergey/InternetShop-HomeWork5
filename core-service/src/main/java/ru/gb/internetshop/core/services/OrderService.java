package ru.gb.internetshop.core.services;

import api.CartDto;
import api.CartItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.gb.internetshop.core.entities.Order;
import ru.gb.internetshop.core.entities.OrderItem;
import ru.gb.internetshop.core.entities.Product;
import ru.gb.internetshop.core.entities.User;
import ru.gb.internetshop.core.exceptions.ResourceNotFoundException;
import ru.gb.internetshop.core.integrations.CartServiceIntegration;
import ru.gb.internetshop.core.repositories.OrderItemRepository;
import ru.gb.internetshop.core.repositories.OrderRepository;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductService productService;
    private final CartServiceIntegration cartServiceIntegration;
    private final UserService userService;
    private final OrderItemRepository orderItemRepository;

    @Transactional
    public void createOrder(String username){
        CartDto cartDto = cartServiceIntegration.getCurrentCart();
        User user = userService.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("Пользователь не найден"));
        Order order=new Order();
        order.setUser(user);
        order.setTotalPrice(cartDto.getTotalPrice());
        List<OrderItem> orderItemList = new ArrayList<>();
        for (CartItemDto c: cartDto.getItems()){
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setPrice(c.getPrice());
            orderItem.setAmount(c.getAmount());
            Product product=productService.findById(c.getId()).orElseThrow(()->new ResourceNotFoundException("Продукт с id="+c.getId()+" не найден"));
            orderItem.setProduct(product);
            orderItemList.add(orderItem);
        }
        order.setItems(orderItemList);
        orderRepository.save(order);
        orderItemRepository.saveAll(orderItemList);
        cartServiceIntegration.clearCart();
//        OrderItem orderItem = new OrderItem();
//        List<OrderItem> list=new ArrayList<>();
//        for (CartItemDto c: cartDto.getItems()){
//            orderItem.setProduct(productService.findById(c.getId()).get());
//            orderItem.setOrder();
//        }
    }
}
