package com.cts.fmsjwt.controller;
/**
 * @author 849289
 * */
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.fmsjwt.model.AuthenticationRequest;
import com.cts.fmsjwt.model.AuthenticationResponse;
import com.cts.fmsjwt.security.PBKDF2Encoder;
import com.cts.fmsjwt.service.UserDetailsService;
import com.cts.fmsjwt.utils.JWTUtil;

import reactor.core.publisher.Mono;


@RestController
public class FMSAuthentication {
	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private PBKDF2Encoder passwordEncoder;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Mono<ResponseEntity<?>> login(@RequestBody AuthenticationRequest ar) {
		return userDetailsService.findById(ar.getUsername()).map((userDetails) -> {
			/*Base64.Encoder encoder = Base64.getEncoder();
			 String str = encoder.encodeToString(ar.getPassword().getBytes()); 
			System.out.println("StR :"+str);*/
			
			if (passwordEncoder.encode(ar.getPassword()).equals(userDetails.getPassword())) {
				return ResponseEntity.ok(new AuthenticationResponse(jwtUtil.generateToken(userDetails)));
			} else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
			}
		}).defaultIfEmpty(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public Mono<ResponseEntity<?>> test(@RequestParam AuthenticationRequest ar) {
		return userDetailsService.findById(ar.getUsername()).map((userDetails) -> {
			System.out.println(ar.getPassword()+"===="+userDetails.getPassword());
			if (passwordEncoder.encode(ar.getPassword()).equals(userDetails.getPassword())) {
				return ResponseEntity.ok(new AuthenticationResponse(jwtUtil.generateToken(userDetails)));
			} else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
			}
		}).defaultIfEmpty(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}

}
