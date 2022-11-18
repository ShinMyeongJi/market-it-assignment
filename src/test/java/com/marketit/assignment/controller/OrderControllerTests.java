package com.marketit.assignment.controller;


import com.marketit.assignment.entity.Order;
import com.marketit.assignment.entity.OrderItem;
import com.marketit.assignment.entity.OrderStatus;
import com.marketit.assignment.repository.OrderItemRepository;
import com.marketit.assignment.repository.OrderRepository;
import com.marketit.assignment.service.OrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import javax.transaction.Transactional;
import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
@SpringBootTest
@Transactional
@AutoConfigureMockMvc
public class OrderControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    private Long testOrderId = 1l;

    @Test
    @DisplayName("주문 접수 처리 API 테스트")
    void orderAcceptTest() throws Exception {
        create();
        mockMvc.perform(
                        put("/api/orders/{id}/accept", testOrderId)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("주문 완료 처리 API 테스트")
    void orderCompleteTest() throws Exception {
        create();
        mockMvc.perform(
                        put("/api/orders/{id}/complete", testOrderId)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("단일 주문 조회 API 테스트")
    void getOrderByIdTest() throws Exception {
        create();
        mockMvc.perform(
                        get("/api/orders/{id}", testOrderId)
                )
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    @DisplayName("주문 목록조회 API 테스트")
    void getOrdersTest() throws Exception {
        create();
        mockMvc.perform(
                        get("/api/orders")
                )
                .andDo(print())
                .andExpect(status().isOk());
    }


    Order create() {
        Order order = Order.builder()
                .id(testOrderId)
                .orderStatus(OrderStatus.CREATED)
                .orderItemList(new ArrayList<>())
                .build();

        OrderItem orderItem = OrderItem.builder()
                .id(1l)
                .name("jenas")
                .order(order)
                .build();

        OrderItem orderItem2 = OrderItem.builder()
                .id(1l)
                .name("jenas")
                .order(order)
                .build();

        orderRepository.save(order);
        orderItemRepository.save(orderItem);
        orderItemRepository.save(orderItem2);
        return order;
    }

}