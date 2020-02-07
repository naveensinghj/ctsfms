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
@Table("employee_role")
@Setter @Getter
public class EmployeeRole implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Long id;
	private Long employee_id;
	private Integer employee_role;
	/*private Employee employee;
	private Roles roles; */

}
