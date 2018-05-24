package com.rone.personnelManagement.bean;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Salary {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(unique = false)
	private Employee employee;
	private int days;
	private Date date;
	private double salary;
	private double bonus;
	private double overtimePay;
	
	public Salary(Employee employee, Date date) {
		super();
		this.employee = employee;
		this.date = date;
	}

	public Salary() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public double getOvertimePay() {
		return overtimePay;
	}

	public void setOvertimePay(double overtimePay) {
		this.overtimePay = overtimePay;
	}

	@Override
	public String toString() {
		return "Salary [id=" + id + ", employee=" + employee.getName() + ", days=" + days + ", date=" + date + ", salary="
				+ salary + ", bonus=" + bonus + ", overtimePay=" + overtimePay + "]";
	}

	
	
	
	
}
