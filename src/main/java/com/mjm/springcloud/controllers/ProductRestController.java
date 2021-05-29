package com.mjm.springcloud.controllers;

import com.mjm.springcloud.dto.Coupon;
import com.mjm.springcloud.model.Product;
import com.mjm.springcloud.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
@RequestMapping("/productapi")
public class ProductRestController {

    @Autowired
    private ProductRepo repo;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${couponService.url}")
    private String couponServiceURL;

    @PostMapping(value = "/products")
    public Product create(@RequestBody Product product) {
        Coupon coupon = restTemplate.getForObject(couponServiceURL + product.getCouponCode(), Coupon.class);
        product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
        return repo.save(product);
    }

    @GetMapping("/products/{id}")
    public Optional<Product> getProduct(@PathVariable("id") Long id) {
        return repo.findById(id);
    }
}
