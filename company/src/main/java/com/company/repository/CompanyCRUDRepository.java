package com.company.repository;

import com.company.entity.CompanyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CompanyCRUDRepository extends CrudRepository<CompanyEntity, UUID> {
}
