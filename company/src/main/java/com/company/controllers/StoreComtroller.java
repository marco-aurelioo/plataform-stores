package com.company.controllers;

import com.company.business.StoreBusiness;
import com.company.model.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("{companyId}/store")
public class StoreComtroller {

    @Autowired
    private StoreBusiness storeBusiness;

    @GetMapping("/")
    public ResponseEntity<List<Store>> getAllStores(@PathVariable("companyId") String companyid ){
        return new ResponseEntity<List<Store>>(storeBusiness.getAllStores(companyid), HttpStatus.OK);
    }

    @GetMapping("/{storeId}")
    public ResponseEntity<Store> getStore(@PathVariable("companyId") String companyid,
                           @PathVariable("storeId") String storeid){
        return new ResponseEntity<Store>(storeBusiness.findStore(companyid,storeid),HttpStatus.OK);
    }

    @DeleteMapping("/{storeId}")
    public ResponseEntity<Boolean> deleteStore(@PathVariable("companyId") String companyid,
                              @PathVariable("storeId") String storeid){
        return new ResponseEntity<Boolean>(storeBusiness.deleteStore(companyid,storeid),HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Store> createStore(@PathVariable("companyId") String companyid,
                              @RequestBody Store store){
        return new ResponseEntity<Store>(storeBusiness.createStore(companyid,store),HttpStatus.OK);
    }

    @PutMapping("/{storeId}")
    public ResponseEntity<Store> updateStore(@PathVariable("companyId") String companyid,
                              @PathVariable("storeId") String storeid,
                              @RequestBody Store store){
        return new ResponseEntity<Store>(storeBusiness.updateStore(companyid,storeid,store),HttpStatus.OK);
    }
}
