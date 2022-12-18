package ru.gb.internetshop.core.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gb.internetshop.core.entities.Order;
import ru.gb.internetshop.core.entities.User;

import java.util.Optional;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

}
