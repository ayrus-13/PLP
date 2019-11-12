package com.cg.ams.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="employee")
public class Employee
{
	@Id
	@Column(name="Empno")
	private Integer empNo;

	@Column(name="Ename")
	private String eName;

	@Column(name="job")
	private String job;

	@Column(name="mgr")
	private Integer mgrNo;

	@Column(name="hiredate")
	private String hireDate;

	@JsonIgnore
	@OneToMany(mappedBy = "employee")
	private List<AllocationRequest> ARequests;

	public List<AllocationRequest> getARequests() {
		return ARequests;
	}
	public void setARequests(List<AllocationRequest> aRequests) {
		ARequests = aRequests;
	}
	public Employee(List<AllocationRequest> aRequests) {
		super();
		ARequests = aRequests;
	}
	public Integer getEmpNo() {
		return empNo;
	}
	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}
	public String getEName() {
		return eName;
	}
	public void setEName(String eName) {
		this.eName = eName;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Integer getMgrNo() {
		return mgrNo;
	}
	public void setMgrno(Integer mgrNo) {
		this.mgrNo = mgrNo;
	}
	public String getHireDate() {
		return hireDate;
	}
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", eName=" + eName + ", job=" + job + ", mgrNo=" + mgrNo + ", hireDate="
				+ hireDate + ", ARequests=" + ARequests + "]";
	}

}