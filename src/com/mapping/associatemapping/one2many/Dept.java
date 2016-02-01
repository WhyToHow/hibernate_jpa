package com.mapping.associatemapping.one2many;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mapping.associatemapping.many2one.Employee;

@Entity
@Table(name="t_dept")
public class Dept {
	private Integer deptId;
	private String deptName;
	//一对多---一个部门对应多个员工
	private Set<Employee> employees;
	@Id
	@Column(name="dept_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	@Basic
	@Column(name="dept_name",columnDefinition="varchar2(20)")
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	//one一方为被维护端  需要指定mappedBy 映射的属性
	@OneToMany(targetEntity=Employee.class,mappedBy="dept")
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	

}
