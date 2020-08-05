package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Address;
import com.example.demo.entity.Employee;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repositroy.AddressRepository;
import com.example.demo.repositroy.EmployeeRepository;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private AddressRepository addressRepository;

	@GetMapping
	public List<Employee> getAllUser() {

		return this.employeeRepository.findAll();

	}

	@GetMapping("/{id}")
	public Employee getUserById(@PathVariable(value = "id") long empId) {

		return this.employeeRepository.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("usernot Found Exception" + empId));

	}

	@PostMapping("/createEmployee")
	public Employee createEmployee(@RequestBody Employee employee) {
		return this.employeeRepository.save(employee);

	}
	
	@PostMapping("/createAddress")
	public Address createAddress(@RequestBody Address address) {
		return this.addressRepository.save(address);

	}

	@PutMapping("/update/{id}")
	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable("id") long empId) {
		Employee existingEmpl = this.employeeRepository.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("usernot Found Exception" + empId));

		existingEmpl.setName(employee.getName());
		return this.employeeRepository.save(existingEmpl);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Employee> deleteuemp(@PathVariable("id") long empId) {
		Employee existingEmployee = this.employeeRepository.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException("usernot Found Exception" + empId));
		this.employeeRepository.delete(existingEmployee);
		return ResponseEntity.ok().build();

	}
}