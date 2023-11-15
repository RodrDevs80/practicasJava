package com.sertec.JSB.entityR.repository;

import com.sertec.JSB.entityR.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

}
