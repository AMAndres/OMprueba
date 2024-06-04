package dev.amandres.omprueba.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false)
    private Integer items;

    @Column(nullable = false)
    private Double baseAmount;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private Integer status;

    @OneToOne(mappedBy = "order_id")
    private OrderProduct orderProduct;

    // Getters and Setters
}