package com.example.chaos.monkey.shopping.gateway.rest;

import com.example.chaos.monkey.shopping.domain.Product;
import com.example.chaos.monkey.shopping.gateway.commands.BestsellerFashionCommand;
import com.example.chaos.monkey.shopping.gateway.commands.BestsellerToysCommand;
import com.example.chaos.monkey.shopping.gateway.commands.HotDealsCommand;
import com.example.chaos.monkey.shopping.gateway.domain.ProductResponse;
import com.example.chaos.monkey.shopping.gateway.domain.ResponseType;
import com.example.chaos.monkey.shopping.gateway.domain.Startpage;
import com.example.chaos.monkey.shopping.gateway.services.FashionService;
import com.example.chaos.monkey.shopping.gateway.services.HotDealsService;
import com.example.chaos.monkey.shopping.gateway.services.ToysService;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.Future;

/**
 * @author Benjamin Wilms
 */
@RestController
@RequestMapping("/legacy")
public class ApiGatewayLegacyRestController {

    private final FashionService fashionService;
    private final ToysService toysService;
    private HotDealsService hotDealsService;

    public ApiGatewayLegacyRestController(HotDealsService hotDealsService, FashionService fashionService, ToysService toysService) {
        this.hotDealsService = hotDealsService;
        this.fashionService = fashionService;
        this.toysService = toysService;
    }

    @GetMapping("/startpage")
    public Startpage getStartpage() {
        Startpage page = new Startpage();
        long start = System.currentTimeMillis();


        // Get Responses from Futures
        page.setFashionResponse(extractResponse(fashionService.getFashionBestseller()));
        page.setToysResponse(extractResponse(toysService.getToysBestseller()));
        page.setHotDealsResponse(extractResponse(hotDealsService.getHotDeals()));

        // Summary
        page.setStatusFashion(page.getFashionResponse().getResponseType().name());
        page.setStatusToys(page.getToysResponse().getResponseType().name());
        page.setStatusHotDeals(page.getHotDealsResponse().getResponseType().name());

        // Request duration
        page.setDuration(System.currentTimeMillis() - start);
        return page;
    }

    private ProductResponse extractResponse(List<Product> products) {
        return new ProductResponse(ResponseType.REMOTE_SERVICE, products);

    }


    private Future<ProductResponse> getHotDeals() {
        return new HotDealsCommand(HystrixCommandGroupKey.Factory.asKey("hotdeals"), 200, hotDealsService).queue();
    }

    private Future<ProductResponse> getBestsellerToys() {
        return new BestsellerToysCommand(HystrixCommandGroupKey.Factory.asKey("toys"), 200, toysService).queue();
    }

    private Future<ProductResponse> getBestsellerFashion() {
        return new BestsellerFashionCommand(HystrixCommandGroupKey.Factory.asKey("fashion"), 200, fashionService).queue();
    }

}
