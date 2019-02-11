package com.example.chaos.monkey.shopping.gateway.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import com.example.chaos.monkey.shopping.domain.Product;

/**
 * @author Benjamin Wilms
 */

//@NoArgsConstructor
//@AllArgsConstructor
//@Data
public class ProductResponse {

    private ResponseType responseType;
    private List<Product> products;

    public ResponseType getResponseType() {
        return responseType;
    }

    public void setResponseType(ResponseType responseType) {
        this.responseType = responseType;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public ProductResponse(ResponseType responseType, List<Product> products) {
        this.responseType = responseType;
        this.products = products;
    }

    public ProductResponse() {}
}
