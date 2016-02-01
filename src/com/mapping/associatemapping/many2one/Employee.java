package com.mapping.associatemapping.many2one;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.mapping.associatemapping.one2many.Dept;

@Entity
@Table(name="t_employee")
public class Employee {
	private Integer employeeId;
	private String employeeName;
	//多对一  员工对部门是多对一的关系
	private Dept dept;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="emp_id")
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	@Basic
	@Column(name="emp_name",columnDefinition="varchar2(20)")
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	//在jpa中 many为维护端  需要指定ManyToOne注解 还需要JoinColumn指定外键字段
	@JoinColumn(name="dept_id")
	@ManyToOne(targetEntity=Dept.class)
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	
}
