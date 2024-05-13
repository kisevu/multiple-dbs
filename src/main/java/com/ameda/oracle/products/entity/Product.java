package com.ameda.oracle.products.entity;/*
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

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue
    private Integer productId;
    private String name;
    private Double price;
}
