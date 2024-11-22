package com.sathya.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sathya.mvc.Entites.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
