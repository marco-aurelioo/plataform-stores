package com.company.repository;

import com.company.entity.StoreEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StoreCRUdRepository extends CrudRepository<StoreEntity, UUID> {

    @Query("from StoreEntity store inner join store.company company where company.id = :companyId ")
    List<StoreEntity> findByCompanyId(@Param("companyId") UUID companyId);

    @Query("from StoreEntity store inner join store.company company where company.id = :companyId and store.id = :storeId ")
    StoreEntity findByCompanyIdAndStoreID(@Param("companyId") UUID companyId, @Param("storeId") UUID storeId);

}
