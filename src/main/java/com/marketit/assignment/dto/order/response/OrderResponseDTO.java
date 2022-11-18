package com.marketit.assignment.dto.order.response;

import com.marketit.assignment.entity.Order;
import com.marketit.assignment.entity.OrderItem;
import com.marketit.assignment.entity.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class OrderResponseDTO {

    private Long id;
    private OrderStatus orderStatus;
    private List<String> orderItems;

    public OrderResponseDTO(Order order) {
        this.id = order.getId();
        this.orderStatus = order.getOrderStatus();
        this.orderItems = order.getOrderItemList().stream()
                .map(OrderItem::getName)
                .collect(Collectors.toList());
    }
}
