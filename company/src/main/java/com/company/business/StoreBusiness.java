package com.company.business;

import com.company.entity.CompanyEntity;
import com.company.entity.StoreEntity;
import com.company.model.Store;
import com.company.repository.StoreCRUdRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class StoreBusiness {


    @Autowired
    private CompanyBusiness companyBusiness;

    @Autowired
    private StoreCRUdRepository storeCRUdRepository;

    public List<Store> getAllStores(String companyid) {
        UUID id = UUID.fromString(companyid);
        List<StoreEntity> entities = storeCRUdRepository.findByCompanyId(id);
        List<Store> stories = new ArrayList<>();
        for(StoreEntity entity : entities){
            stories.add(fromEntity(entity));
        }
        return stories;
    }

    public Store findStore(String companyuuid, String storeuuid) {
        UUID companyId = UUID.fromString(companyuuid);
        UUID storeId = UUID.fromString(storeuuid);
        StoreEntity entity = storeCRUdRepository.findByCompanyIdAndStoreID(companyId,storeId);
        Store store = fromEntity(entity);
        return store;
    }

    public Boolean deleteStore(String companyuuid, String storeuuid) {
        UUID companyId = UUID.fromString(companyuuid);
        UUID storeId = UUID.fromString(storeuuid);
        StoreEntity entity = storeCRUdRepository.findByCompanyIdAndStoreID(companyId,storeId);
        storeCRUdRepository.delete(entity);
        return true;
    }

    public Store createStore(String companyuuid, Store store) {
        StoreEntity entity = fromPojo(store);
        CompanyEntity companyEntity = companyBusiness.findCompanyEntity(companyuuid);
        entity.setCompany(companyEntity);
        entity = storeCRUdRepository.save(entity);
        Store createdStore = fromEntity(entity);
        return createdStore;
    }

    public Store updateStore(String companyuuid, String storeuuid, Store store) {
        UUID companyId = UUID.fromString(companyuuid);
        UUID storeId = UUID.fromString(storeuuid);
        StoreEntity entity = storeCRUdRepository.findByCompanyIdAndStoreID(companyId,storeId);
        StoreEntity storeFromPojo = fromPojo(store);
        BeanUtils.copyProperties(storeFromPojo,entity);
        entity = storeCRUdRepository.save(entity);
        Store storeUpdated = fromEntity(entity);
        return storeUpdated;
    }

    private StoreEntity fromPojo(Store store) {
        StoreEntity entity = new StoreEntity();
        BeanUtils.copyProperties(store,entity);
        return entity;
    }

    private Store fromEntity(StoreEntity entity) {
        Store store = new Store();
        BeanUtils.copyProperties(entity,store);
        return store;
    }
}
