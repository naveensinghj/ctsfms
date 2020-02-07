package com.cts.fmsjwt.service;

/**
 * @author 849289
 * */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.fmsjwt.model.User;
import com.cts.fmsjwt.repository.UserDetailsRepository;

import reactor.core.publisher.Mono;

@Service
public class UserDetailsService {

	@Autowired
	UserDetailsRepository userDetailsRepository;
	public Mono<User> findById(String userId){
		return userDetailsRepository.findById(userId);
	}
}
