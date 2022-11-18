package com.marketit.assignment.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "order_item")
@Getter
public class OrderItem implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    OrderItem() {}

    @Builder
    public OrderItem(Long id,
                     String name,
                     Order order) {
        this.id = id;
        this.name = name;
        this.order = order;
    }

}
