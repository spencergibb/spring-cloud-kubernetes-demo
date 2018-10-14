package com.example.chaos.monkey.shopping.gateway.commands;

import com.example.chaos.monkey.shopping.domain.Product;
import com.example.chaos.monkey.shopping.gateway.domain.ProductResponse;
import com.example.chaos.monkey.shopping.gateway.domain.ResponseType;
import com.example.chaos.monkey.shopping.gateway.services.HotDealsService;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import java.util.Collections;

/**
 * @author Benjamin Wilms
 */
public class HotDealsCommand extends HystrixCommand<ProductResponse> {


    private final HotDealsService hotDealsService;

    public HotDealsCommand(HystrixCommandGroupKey group, int timeout, HotDealsService hotDealsService) {
        super(group, timeout);
        this.hotDealsService = hotDealsService;
    }

    protected ProductResponse run() {
        ProductResponse response = new ProductResponse();

        response.setProducts(hotDealsService.getHotDeals());

        response.setResponseType(ResponseType.REMOTE_SERVICE);

        return response;
    }

    @Override
    protected ProductResponse getFallback() {
        return new ProductResponse(ResponseType.FALLBACK, Collections.<Product>emptyList());
    }
}
