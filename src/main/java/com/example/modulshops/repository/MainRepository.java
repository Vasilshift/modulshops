/**
 * @author Vasilshift
 */
package com.example.modulshops.repository;

import com.example.modulshops.mapper.OneShopProductListMapper;
import com.example.modulshops.mapper.ProductListMapper;
import com.example.modulshops.mapper.ShopMapper;
import com.example.modulshops.model.rest.Shop;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class MainRepository {

    private final JdbcTemplate jdbcTemplate;

    public List<Shop> getShopListAllRepo() {
        List<Shop> shopList = jdbcTemplate.query(
                "SELECT * FROM shop", new ShopMapper());
        return shopList;
    }

    public List<Shop> getOneShopListProductsRepo(int id) {
        //String query = "SELECT shop.id AS idShop, shop.shop_name AS shopName FROM shop WHERE shop.id = " + id;
        String query = "SELECT shop.id AS idShop,"  +
                "shop.shop_name AS shopName, " +
                "product.id AS idProduct, product.product_name AS productName, " +
                "product.count AS count FROM shop inner join product ON shop.id = product.id_shop WHERE shop.id = " + id;
        List<Shop> shop = jdbcTemplate.query(query, new OneShopProductListMapper());
        return shop;
    }

    public List<Shop.Product> getProductListOneShopRepo(int id) {
        //String query = "SELECT * FROM shop WHERE shop.id = " + id;
        String query = "SELECT " +
                "product.id AS idProduct, product.product_name AS productName, " +
                "product.count AS count FROM shop inner join product ON shop.id = product.id_shop WHERE shop.id = " + id;

        List<Shop.Product> productListOneShop = jdbcTemplate.query(query, new ProductListMapper());
        System.out.println("productListOneShop: " + productListOneShop);
        return productListOneShop;
    }

    public List<Shop.Product> getProductListRepo(){
        String query = "SELECT product.id AS idProduct, product.product_name AS productName, product.count AS count FROM product";
        List<Shop.Product> list = jdbcTemplate.query(query, new ProductListMapper());
        return list;
    }



}