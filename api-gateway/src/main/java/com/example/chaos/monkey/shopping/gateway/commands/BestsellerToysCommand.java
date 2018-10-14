package com.example.chaos.monkey.shopping.gateway.commands;

import com.example.chaos.monkey.shopping.domain.Product;
import com.example.chaos.monkey.shopping.gateway.domain.ProductResponse;
import com.example.chaos.monkey.shopping.gateway.domain.ResponseType;
import com.example.chaos.monkey.shopping.gateway.services.ToysService;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import java.util.Collections;

/**
 * @author Benjamin Wilms
 */
public class BestsellerToysCommand extends HystrixCommand<ProductResponse> {

    private final ToysService toysService;


    public BestsellerToysCommand(HystrixCommandGroupKey group, int timeout, ToysService toysService) {
        super(group, timeout);
        this.toysService = toysService;
    }

    protected ProductResponse run() {
        ProductResponse response = new ProductResponse();

        response.setProducts(toysService.getToysBestseller());

        response.setResponseType(ResponseType.REMOTE_SERVICE);

        return response;


    }

    @Override
    protected ProductResponse getFallback() {
        return new ProductResponse(ResponseType.FALLBACK, Collections.<Product>emptyList());
    }
}
