package com.jsframe.spring_jpa.repository;

import com.jsframe.spring_jpa.entity.Product;
import org.springframework.data.repository.CrudRepository;

// CrudRepository<entity / id에 해당하는 타입>
public interface ProductRepository extends CrudRepository<Product, Long> {
}
