package com.amljdhv.product;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("productDetailRepository")
public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long>{
}
