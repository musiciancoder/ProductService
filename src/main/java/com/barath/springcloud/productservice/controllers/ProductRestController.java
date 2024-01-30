package com.barath.springcloud.productservice.controllers;

import com.barath.springcloud.productservice.model.Product;
import com.barath.springcloud.productservice.repos.ProductRepo;
import dto.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/productapi")
public class ProductRestController {

    @Autowired
    private ProductRepo repo;

    @Autowired
    private RestTemplate restTemplate; //spring web dependency offers this to comunicate between services

    @Value("${couponService.url}")
    private String couponServiceURL;

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public Product create(@RequestBody Product product){
        Coupon coupon = restTemplate.getForObject(couponServiceURL + product.getCouponCode(), Coupon.class); // obtener descuento q viene de couponservice
        product.setPrice(product.getPrice().subtract(coupon.getDicount())); //aplicar descuento
        return repo.save(product);
    }
}
