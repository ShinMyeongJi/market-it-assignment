package com.marketit.assignment.controller;

import com.marketit.assignment.dto.order.ResponseResult;
import com.marketit.assignment.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;

    @PutMapping("/api/orders/{id}/accept")
    public ResponseEntity<Void> accept(@PathVariable("id") Long id) {
        orderService.acceptOrder(id);
        return ResponseEntity.noContent().build();
    }

   @PutMapping("/api/orders/{id}/complete")
    public ResponseEntity<Void> complete(@PathVariable("id") Long id) {
       orderService.completeOrder(id);
       return ResponseEntity.noContent().build();
    }

    @GetMapping("/api/orders/{id}")
    public ResponseEntity<ResponseResult> getOrder(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(new ResponseResult(HttpStatus.OK, orderService.getOrder(id)));
    }

    @GetMapping("/api/orders")
    public ResponseEntity<ResponseResult> accept() {
        return ResponseEntity.ok().body(new ResponseResult(HttpStatus.OK, orderService.getOrders()));
    }
}
