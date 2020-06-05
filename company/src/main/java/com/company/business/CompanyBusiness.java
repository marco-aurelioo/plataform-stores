package com.company.business;

import com.company.entity.CompanyEntity;
import com.company.model.Company;
import com.company.repository.CompanyCRUDRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    /***
     * create
     * read
     * update
     * delete
     */

}
