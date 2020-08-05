package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.sun.istack.NotNull;

@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "AddressLineOne")
	private String addrLineOne;

	@Column(name = "AddressLineTwo")
	private String addrLineTwo;

	@NotNull
	@Column(name = "City")
	private String city;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "addr")
	private Set<Employee> emps = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddrLineOne() {
		return addrLineOne;
	}

	public void setAddrLineOne(String addrLineOne) {
		this.addrLineOne = addrLineOne;
	}

	public String getAddrLineTwo() {
		return addrLineTwo;
	}

	public void setAddrLineTwo(String addrLineTwo) {
		this.addrLineTwo = addrLineTwo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Set<Employee> getEmps() {
		return emps;
	}

	public void setEmps(Set<Employee> emps) {
		this.emps = emps;
	}
	
	

}
