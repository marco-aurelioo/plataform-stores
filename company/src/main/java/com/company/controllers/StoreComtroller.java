package com.company.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("{companyId}/store")
public class StoreComtroller {

    @GetMapping("/")
    public String getAllStores(@PathVariable("companyId") String companyid ){
        return companyid;
    }

    @GetMapping("/{storeId}")
    public String getStore(@PathVariable("companyId") String companyid,
                           @PathVariable("storeId") String storeid){
        return companyid+"--"+storeid;
    }

    @DeleteMapping("/{storeId}")
    public String deleteStore(@PathVariable("companyId") String companyid,
                              @PathVariable("storeId") String storeid){
        return companyid+"--"+storeid;
    }

    @PostMapping("/")
    public String createStore(@PathVariable("companyId") String companyid){
        return "created for "+companyid;
    }

    @PutMapping("/{storeId}")
    public String updateStore(@PathVariable("companyId") String companyid,
                              @PathVariable("storeId") String storeid){
        return companyid+"--"+storeid;
    }
}
