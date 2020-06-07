package com.product.controller;

import com.product.business.ProductBusiness;
import com.product.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class ProductController {

    @Autowired
    private ProductBusiness productBusiness;

    @GetMapping(value = "{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long productid){
        return new ResponseEntity<Product>(productBusiness.getProduct(productid), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        return new ResponseEntity<Product>(productBusiness.createProduct(product), HttpStatus.OK);
    }

    @PutMapping(value="{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long productid,
                                                 @RequestBody Product product){
        return new ResponseEntity<Product>(productBusiness.updateProduct(productid,product), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable Long productid){
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }
}
