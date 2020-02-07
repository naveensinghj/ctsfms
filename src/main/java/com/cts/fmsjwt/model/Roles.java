package com.cts.fmsjwt.model;
/**
 * @author 849289
 * */
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@ToString 
@AllArgsConstructor
@NoArgsConstructor
@Table("roles")
public class Roles implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	private String role_name;

}
