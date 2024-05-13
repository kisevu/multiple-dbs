package com.ameda.oracle.products.repository;/*
*
@author ameda
@project mDS
*
*/

import com.ameda.oracle.products.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product,Integer> {
}
