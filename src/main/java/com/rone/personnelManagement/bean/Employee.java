package com.rone.personnelManagement.bean;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ID;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String sex;
	@Column(nullable = false)
	private String national;
	@Column(nullable = false, unique = true)
	private String phone;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String nativePlace;
	@Column(nullable = false)
	private String graduateSchool;
	@Column(nullable = false)
	private String education;
	@ManyToOne(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
	@JoinColumn(name = "department_id")
	private Department department;
	@Column(nullable = false)
	private String position;
	@Column(nullable = false)
	private Date hireDate;
	@Column(nullable = false)
	private String address;
	@Column(nullable = false)
	private String maritalStatus;
	@Column(nullable = false)
	private String IDCardNumber;
	
	public Employee(String name, String sex, String national, String phone, String email, String nativePlace,
			String graduateSchool, String education, Department department, String position, String address,
			String maritalStatus, String iDCardNumber) {
		this.name = name;
		this.sex = sex;
		this.national = national;
		this.phone = phone;
		this.email = email;
		this.nativePlace = nativePlace;
		this.graduateSchool = graduateSchool;
		this.education = education;
		this.department = department;
		this.position = position;
		this.address = address;
		this.maritalStatus = maritalStatus;
		IDCardNumber = iDCardNumber;
	}
	
	public Employee(String name, String password, String sex, String national, String phone, String email,
			String nativePlace, String graduateSchool, String education, Department department, String position,
			Date hireDate, String address, String maritalStatus, String iDCardNumber) {
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.national = national;
		this.phone = phone;
		this.email = email;
		this.nativePlace = nativePlace;
		this.graduateSchool = graduateSchool;
		this.education = education;
		this.department = department;
		this.position = position;
		this.hireDate = hireDate;
		this.address = address;
		this.maritalStatus = maritalStatus;
		this.IDCardNumber = iDCardNumber;
	}
	
	
	
	public Employee(String name, String password) {
		this.name = name;
		this.password = password;
	}



	public Employee() {}
	
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getNational() {
		return national;
	}
	public void setNational(String national) {
		this.national = national;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNativePlace() {
		return nativePlace;
	}
	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}
	public String getGraduateSchool() {
		return graduateSchool;
	}
	public void setGraduateSchool(String graduateSchool) {
		this.graduateSchool = graduateSchool;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getIDCardNumber() {
		return IDCardNumber;
	}
	public void setIDCardNumber(String iDCardNumber) {
		IDCardNumber = iDCardNumber;
	}
	@Override
	public String toString() {
		return "Employee [ID=" + ID + ", name=" + name + ", password=" + password + ", sex=" + sex + ", national="
				+ national + ", phone=" + phone + ", email=" + email + ", nativePlace=" + nativePlace
				+ ", graduateSchool=" + graduateSchool + ", education=" + education + ", department="
				+ department.getName() + ", position=" + position + ", hireDate=" + hireDate + ", address="
				+ address + ", maritalStatus=" + maritalStatus + ", IDCardNumber=" + IDCardNumber + "]";
	}
	
	
	
}
