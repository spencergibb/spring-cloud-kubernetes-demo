package com.example.chaos.monkey.shopping.gateway.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Mono;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author Benjamin Wilms
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonPropertyOrder({ "fashionResponse", "toysResponse", "hotDealsResponse", "duration", "statusFashion","statusToys","statusHotDeals" })
public class Startpage {

    private long duration;
    private String statusFashion;
    private String statusToys;
    private String statusHotDeals;
    private ProductResponse fashionResponse;
    private ProductResponse toysResponse;
    private ProductResponse hotDealsResponse;

    public void setFashionResponse(ProductResponse fashionResponse) {
        this.setStatusFashion(fashionResponse.getResponseType().name());
        this.fashionResponse = fashionResponse;
    }

    public void setToysResponse(ProductResponse toysResponse) {
        this.setStatusToys(toysResponse.getResponseType().name());
        this.toysResponse = toysResponse;
    }

    public void setHotDealsResponse(ProductResponse hotDealsResponse) {
        this.setStatusHotDeals(hotDealsResponse.getResponseType().name());
        this.hotDealsResponse = hotDealsResponse;
    }
}
