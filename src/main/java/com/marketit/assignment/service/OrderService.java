package com.marketit.assignment.service;

import com.marketit.assignment.dto.order.response.OrderResponseDTO;
import com.marketit.assignment.entity.Order;
import com.marketit.assignment.entity.OrderStatus;
import com.marketit.assignment.exception.CustomException;
import com.marketit.assignment.exception.types.OrderExceptionTypes;
import com.marketit.assignment.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;

    @Transactional
    public void acceptOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new CustomException(OrderExceptionTypes.ORDER_NOT_FOUND));

        order.updateOrderStatus(OrderStatus.ACCEPTED);
    }

    @Transactional
    public void completeOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new CustomException(OrderExceptionTypes.ORDER_NOT_FOUND));

        order.updateOrderStatus(OrderStatus.COMPLETED);
    }

    public OrderResponseDTO getOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new CustomException(OrderExceptionTypes.ORDER_NOT_FOUND));

        return new OrderResponseDTO(order);
    }

    public List<OrderResponseDTO> getOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(OrderResponseDTO::new)
                .collect(Collectors.toList());
    }
}
