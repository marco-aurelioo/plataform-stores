package com.product.business;

import com.product.entity.ProductEntity;
import com.product.model.Product;
import com.product.repository.ProductCRUDRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductBusiness {

    @Autowired
    private ProductCRUDRepository  productCRUDRepository;

    public Product getProduct(Long productid) {
        return fromEntity(findById(productid));
    }

    public Product createProduct(Product product) {
        ProductEntity entity = fromPojo(product);
        ProductEntity entitySave = productCRUDRepository.save(entity);
        Product productCreated = fromEntity(entitySave);
        return productCreated;
    }

    public Product updateProduct(Long productid, Product product) {
        ProductEntity entity = findById(productid);
        BeanUtils.copyProperties(product,entity);
        ProductEntity entitySave = productCRUDRepository.save(entity);
        return fromEntity(entitySave);
    }

    protected ProductEntity findById(Long productid){
        Optional<ProductEntity> optionalProductEntity = productCRUDRepository.findById(productid);
        if(optionalProductEntity.isPresent()){
            ProductEntity entity = optionalProductEntity.get();
            return entity;
        }else{
            throw new RuntimeException("Product not found with id "+productid);
        }
    }

    private ProductEntity fromPojo(Product product) {
        ProductEntity entity = new ProductEntity();
        BeanUtils.copyProperties(product,entity);
        return entity;
    }

    private Product fromEntity(ProductEntity entity) {
        Product product = new Product();
        BeanUtils.copyProperties(entity,product);
        return product;
    }

}
