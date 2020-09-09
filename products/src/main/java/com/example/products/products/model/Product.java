package com.example.products.products.model;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Product {
    private String product;
    @Id
    private String productCode;
    private Long price;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
