package com.sertec.JSB.entityR.repository;

import com.sertec.JSB.entityR.domain.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address,Long> {

}
