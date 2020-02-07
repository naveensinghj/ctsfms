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
@Table("employee")
@Getter @Setter
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	private String employeeId;
	private String employeeName;
	private String contactNo;
	private String businessUnit;
	private String emailId;
	/*private Roles roles;*/
	/*private List<EmployeeRole> employeeRole;
	private List<EmployeeCredentials> employeeCredentials;*/
	

}
