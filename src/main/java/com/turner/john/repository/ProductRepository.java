package com.turner.john.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.turner.john.beans.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
