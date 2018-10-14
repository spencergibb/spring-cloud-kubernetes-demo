package com.example.chaos.monkey.shopping.gateway.commands;

import com.example.chaos.monkey.shopping.domain.Product;
import com.example.chaos.monkey.shopping.gateway.domain.ProductResponse;
import com.example.chaos.monkey.shopping.gateway.domain.ResponseType;
import com.example.chaos.monkey.shopping.gateway.services.FashionService;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import java.util.Collections;

/**
 * @author Benjamin Wilms
 */
public class BestsellerFashionCommand extends HystrixCommand<ProductResponse> {

    private final FashionService fashionService;

    public BestsellerFashionCommand(HystrixCommandGroupKey group, int timeout, FashionService fashionService) {
        super(group, timeout);
        this.fashionService = fashionService;
    }

    protected ProductResponse run() {
        ProductResponse response = new ProductResponse();

        response.setProducts(fashionService.getFashionBestseller());

        response.setResponseType(ResponseType.REMOTE_SERVICE);

        return response;


    }

    @Override
    protected ProductResponse getFallback() {
        return new ProductResponse(ResponseType.FALLBACK, Collections.<Product>emptyList());
    }
}
