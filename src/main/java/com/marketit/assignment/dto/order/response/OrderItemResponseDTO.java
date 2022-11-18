package com.marketit.assignment.dto.order.response;

import com.marketit.assignment.entity.OrderItem;
import lombok.Getter;


@Getter
public class OrderItemResponseDTO {
    private String name;
    private int cnt;

    public OrderItemResponseDTO(OrderItem orderItem) {
        this.name = orderItem.getName();
        this.cnt = orderItem.getCnt();
    }
}
