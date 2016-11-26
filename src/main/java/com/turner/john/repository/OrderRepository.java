package com.turner.john.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.turner.john.beans.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

}
