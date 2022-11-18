package com.marketit.assignment.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @Column
    private int cnt;
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
