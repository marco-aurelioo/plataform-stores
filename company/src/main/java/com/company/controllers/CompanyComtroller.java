package com.company.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class CompanyComtroller {

    @GetMapping("/{id}")
    public String  getCompany(@PathVariable("id") String id){
        return id;
    }

    @DeleteMapping("/{id}")
    public String deleteCompany(@PathVariable("id") String id){
        return id;
    }

    @PostMapping("/")
    public String createCompany(){
        return "created";
    }

    @PutMapping("/{id}")
    public String updateCompany(@PathVariable("id") String id){
        return id;
    }

}
