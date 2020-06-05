package com.company.controllers;

import com.company.business.CompanyBusiness;
import com.company.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class CompanyComtroller {

    @Autowired
    private CompanyBusiness companyBusiness;

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompany(@PathVariable("id") String id){
        return new ResponseEntity<Company>(companyBusiness.findById(id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCompany(@PathVariable("id") String id){

        return new ResponseEntity<Boolean>(companyBusiness.delete(id), HttpStatus.OK);
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
