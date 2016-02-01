package com.mapping.associatemapping.many2many;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="t_pro")
public class Project {
	private Integer projectId;
	private String projectName;
	//项目下 有多个员工
	private Set<Developer> developers;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pro_id")
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	@Basic
	@Column(name="pro_name")
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	//被维护方
	
	@ManyToMany(mappedBy="projects")
	public Set<Developer> getDevelopers() {
		return developers;
	}
	public void setDevelopers(Set<Developer> developers) {
		this.developers = developers;
	}
	
}
