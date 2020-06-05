package com.company.business;

import com.company.entity.CompanyEntity;
import com.company.model.Company;
import com.company.repository.CompanyCRUDRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.text.html.parser.Entity;
import java.util.Optional;
import java.util.UUID;

@Component
public class CompanyBusiness {

    @Autowired
    private CompanyCRUDRepository companyCRUDRepository;

    public Boolean delete(String uuid) {
        CompanyEntity entity = findCompanyEntity(uuid);
        companyCRUDRepository.delete(entity);
        return true;
    }

    public Company findById(String uuid) {
        CompanyEntity entity = findCompanyEntity(uuid);
        Company company = fromEntity(entity);
        return company;
    }

    public Company createCompany(Company company) {
        CompanyEntity entity = fromPojo(company);
        entity = companyCRUDRepository.save(entity);
        Company createdCompany = fromEntity(entity);
        return createdCompany;
    }

    public Company updateCompany(Company company, String uuid) {
        CompanyEntity entity = findCompanyEntity(uuid);
        if(entity.getId().equals(company.getId())){
            CompanyEntity entityFromPojo = fromPojo(company);
            BeanUtils.copyProperties(entityFromPojo,entity);
            entity = companyCRUDRepository.save(entity);
            Company companyUpdated = fromEntity(entity);
            return companyUpdated;
        }else{
            throw new RuntimeException("Invalid company to update");
        }
    }

    protected CompanyEntity findCompanyEntity(String uuid){
        UUID id = UUID.fromString(uuid);
        Optional<CompanyEntity> optionalCompanyEntity = companyCRUDRepository.findById(id);
        if(optionalCompanyEntity.isPresent()){
            return optionalCompanyEntity.get();
        }else{
            throw new RuntimeException("Company with uuid:"+uuid+" not exists");
        }
    }

    private Company fromEntity(CompanyEntity entity){
        Company company = new Company();
        BeanUtils.copyProperties(entity,company);
        return company;
    }

    private CompanyEntity fromPojo(Company company) {
        CompanyEntity entity =  new CompanyEntity();
        BeanUtils.copyProperties(company,entity);
        return entity;
    }

}
