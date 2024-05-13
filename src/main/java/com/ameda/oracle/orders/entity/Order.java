package com.ameda.oracle.orders.entity;/*
*
@author ameda
@project mDS
*
*/

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name="orders")
public class Order {
@Id
@GeneratedValue
private Integer orderId;
private String fromWhom;
private LocalDate orderDate;

}
