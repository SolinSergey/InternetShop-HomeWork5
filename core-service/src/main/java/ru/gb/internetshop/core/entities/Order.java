package ru.gb.internetshop.core.entities;

import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="orders")
@NoArgsConstructor
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(name="total_price")
    private int totalPrice;

    @OneToMany(mappedBy = "order", cascade=CascadeType.ALL)
    private List<OrderItem> items;

}
