package com.example.demo.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.sun.istack.NotNull;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(unique = true)
	private String name;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DOB")
	private Date dob = new Date();

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "employee_address", joinColumns = { @JoinColumn(name = "employee_id") }, inverseJoinColumns = {
			@JoinColumn(name = "address_id") })
	private Set<Address> addr = new HashSet<>();

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Set<Address> getAddr() {
		return addr;
	}

	public void setAddr(Set<Address> addr) {
		this.addr = addr;
	}

	public Employee(String name, Date dob, Set<Address> addr) {
		super();
		this.name = name;
		this.dob = dob;
		this.addr = addr;
	}

}
