package com.mapping.associatemapping.many2many;

import java.util.Set;
//多对多的关联 需要有一个中间表  中间表中含有各表的外键字段

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="t_dev")
public class Developer {
	private Integer developerId;
	private String developerName;
	//员工可以有多个项目
	private Set<Project> projects;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="dev_id")
	public Integer getDeveloperId() {
		return developerId;
	}
	public void setDeveloperId(Integer developerId) {
		this.developerId = developerId;
	}
	@Basic
	@Column(name="dev_name")
	public String getDeveloperName() {
		return developerName;
	}
	public void setDeveloperName(String developerName) {
		this.developerName = developerName;
	}
	//维护方 需要设定中间表的双方外键
	@ManyToMany
	@JoinTable(name="t_relation",
			joinColumns={@JoinColumn(name="r_dev_id",
									referencedColumnName="dev_id")
			},
			inverseJoinColumns={@JoinColumn(name="r_pro_id",
							referencedColumnName="pro_id")
			})
	public Set<Project> getProjects() {
		return projects;
	}
	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}
	

}
