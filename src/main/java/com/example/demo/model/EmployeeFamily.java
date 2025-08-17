package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class EmployeeFamily {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "family_details_id")
	private Long familyId;
	@Column(name = "family_member_relation")
	private String familyRelation;
	@Column(name = "family_member_name")
	private String familyMemberName;
	@Column(name = "family_member_age")
	private int familyMemberAge;
	
	@ManyToOne
	@JoinColumn(name="employee_id")
	@JsonBackReference
	private Employee employee;

	@Override
	public String toString() {
		return "EmployeeFamily [familyId=" + familyId + ", familyRelation=" + familyRelation + ", familyMemberName="
				+ familyMemberName + ", familyMemberAge=" + familyMemberAge + "]";
	}

	public Long getFamilyId() {
		return familyId;
	}

	public void setFamilyId(Long familyId) {
		this.familyId = familyId;
	}

	public String getFamilyRelation() {
		return familyRelation;
	}

	public void setFamilyRelation(String familyRelation) {
		this.familyRelation = familyRelation;
	}

	public String getFamilyMemberName() {
		return familyMemberName;
	}

	public void setFamilyMemberName(String familyMemberName) {
		this.familyMemberName = familyMemberName;
	}

	public int getFamilyMemberAge() {
		return familyMemberAge;
	}

	public void setFamilyMemberAge(int familyMemberAge) {
		this.familyMemberAge = familyMemberAge;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
