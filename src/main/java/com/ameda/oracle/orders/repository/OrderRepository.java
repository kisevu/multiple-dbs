package com.ameda.oracle.orders.repository;/*
*
@author ameda
@project mDS
*
*/

import com.ameda.oracle.orders.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order,Integer> {
}
