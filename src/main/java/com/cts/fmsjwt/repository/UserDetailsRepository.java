package com.cts.fmsjwt.repository;
/**
 * @author 849289
 * */
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.fmsjwt.model.User;

@Repository
public interface UserDetailsRepository extends ReactiveCrudRepository<User, String> {

}
