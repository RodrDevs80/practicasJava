package com.sertec.JSB.entityR.repository;

import com.sertec.JSB.entityR.domain.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client,Long> {

}
