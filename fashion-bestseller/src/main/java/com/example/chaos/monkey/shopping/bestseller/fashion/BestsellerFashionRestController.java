package com.example.chaos.monkey.shopping.bestseller.fashion;

import com.example.chaos.monkey.shopping.domain.Product;
import com.example.chaos.monkey.shopping.domain.ProductBuilder;
import com.example.chaos.monkey.shopping.domain.ProductCategory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Benjamin Wilms
 */
@RestController
@RequestMapping("/fashion")
public class BestsellerFashionRestController {

    @GetMapping("/bestseller")
    public List<Product> getBestsellerProducts() {
        AtomicLong id = new AtomicLong(4);

        ProductBuilder productBuilder = new ProductBuilder();

        Product product1 = productBuilder.setCategory(ProductCategory.FASHION).setId(id.getAndIncrement()).setName("Bob Mailor Slim Jeans")
                .createProduct();

        Product product2 = productBuilder.setCategory(ProductCategory.FASHION).setId(id.getAndIncrement()).setName("Lewi's Jeanshose 511 " +
                "Slim Fit")
                .createProduct();

        Product product3 = productBuilder.setCategory(ProductCategory.FASHION).setId(id.getAndIncrement()).setName("Urban Classics T-Shirt " +
                "Shaped Long Tee")
                .createProduct();

        Product product4 = productBuilder.setCategory(ProductCategory.FASHION).setId(id.getAndIncrement()).setName("Star Wars T-Shirt " +
                "Tall")
                .createProduct();
        return Arrays.asList(product1, product2, product3, product4);
    }

}
