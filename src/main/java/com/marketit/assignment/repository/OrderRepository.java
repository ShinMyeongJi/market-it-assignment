package com.marketit.assignment.repository;

import com.marketit.assignment.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
    List<Order> findAll();
}
