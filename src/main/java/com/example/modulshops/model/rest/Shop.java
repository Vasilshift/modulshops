/**
 * @author Vasilshift
 */
package com.example.modulshops.model.rest;

import lombok.*;

import java.util.List;
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Shop {

    private int id;
    private String shop_name;
    private List<Product> productList;

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @EqualsAndHashCode
    public static class Product {
        private int id;
        private String product_name;
        private int count;
    }
}
