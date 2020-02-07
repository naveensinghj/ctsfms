package com.cts.fmsjwt.model;
/**
 * @author 849289
 * */
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString @AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class AuthenticationResponse {
	
	private String token;

}
