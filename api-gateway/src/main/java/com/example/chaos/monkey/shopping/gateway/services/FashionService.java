package com.example.chaos.monkey.shopping.gateway.services;

import com.example.chaos.monkey.shopping.domain.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Benjamin Wilms
 */
@Service
public class FashionService {

    private final RestTemplate restTemplate;

    @Value("${rest.endpoint.fashion}")
    private String urlFashion;

    public FashionService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

    }

    public List<Product> getFashionBestseller() {
        return restTemplate.exchange(urlFashion, HttpMethod.GET, null, new ParameterizedTypeReference<List<Product>>() {
        }).getBody();
    }
}
