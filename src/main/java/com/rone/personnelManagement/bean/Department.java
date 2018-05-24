package com.rone.personnelManagement.bean;

import javax.persistence.*;

@Entity
@Table(name = "Department")
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique = true)
	private String name;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "manager", unique = true, nullable = true)
	private Employee manager;
	
	public Department(String name, Employee manager) {
		this.name = name;
		this.manager = manager;
	}
	
	public Department(String name) {
		super();
		this.name = name;
	}



	public Department() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", manager=" + manager.getName() + "]";
	}

	

	
	
}
