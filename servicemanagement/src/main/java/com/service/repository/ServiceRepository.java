package com.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.service.model.ServiceData;

@Repository
public interface ServiceRepository extends CrudRepository<ServiceData, Integer> {
	
}
