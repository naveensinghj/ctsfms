package com.cts.fmsjwt.model;
/**
 * @author 849289
 * */
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@ToString 
@AllArgsConstructor
@NoArgsConstructor
@Table("employee_credentials")
@Setter @Getter
public class EmployeeCredentials implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	private Long employeeId;
	private String password; 
	

}
