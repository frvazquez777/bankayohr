package com.frvazquez.bankayohr.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.frvazquez.bankayohr.domain.Request;

@Repository
public interface RequestRepository extends CrudRepository<Request, Long> {

}