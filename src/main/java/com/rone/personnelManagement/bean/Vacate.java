package com.rone.personnelManagement.bean;

import javax.persistence.*;

@Entity
public class Vacate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String reason;
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "applicant", nullable = false)
	private Employee applicant;
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "handler", nullable = false)
	private Employee handler;
	@Column(nullable = false)
	private String date;
	@Column(nullable = false)
	private Integer days;
	@Column(nullable = true)
	private String approve;
	
	public Vacate(String reason, Employee applicant, Employee handler, String date, Integer days, String approve) {
		super();
		this.reason = reason;
		this.applicant = applicant;
		this.handler = handler;
		this.date = date;
		this.days = days;
		this.approve = approve;
	}
	
	public Vacate() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Employee getApplicant() {
		return applicant;
	}

	public void setApplicant(Employee applicant) {
		this.applicant = applicant;
	}

	public Employee getHandler() {
		return handler;
	}

	public void setHandler(Employee handler) {
		this.handler = handler;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	public String getApprove() {
		return approve;
	}

	public void setApprove(String approve) {
		this.approve = approve;
	}

	@Override
	public String toString() {
		return "Vacate [id=" + id + ", reason=" + reason + ", applicant=" + applicant.getName() + 
				", handler=" + handler.getName() + ", date=" + date + ", days=" + days + 
				", approve=" + approve + "]";
	}
	
	

	
	
	
	
}
