package com.example.demo.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Repositary.SweetRepository;
import com.example.demo.Repositary.Exception.NoOfferOnThisSweetException;
import com.example.demo.entity.SweetsList;

@RestController
@RequestMapping("SweetProducts")
public class ManageOffer 
{
	@Autowired
	private SweetRepository sweetsrepository;  				//	employeeRepositary present in another package kindly import that
																//sweetmanageoffer=database
	@GetMapping("SweetManageOffer")								//getting employee details on controller 
	public List<SweetsList> getSweetsList()						//import list from util package  //import Employee values
	{
		return this.sweetsrepository.findAll();
	}
	
	
	
	//for getting sweets available 
	@GetMapping("/SweetManageOffer/{id}")
	public ResponseEntity<SweetsList> getSweetsByoffer(@PathVariable (value="id") Long offerId)  // employeeId is the argument passed
	throws NoOfferOnThisSweetException
	{
		SweetsList ss =sweetsrepository.findById(offerId).orElseThrow(() ->new  NoOfferOnThisSweetException("offer not applicable"+offerId));
		return ResponseEntity.ok().body(ss);
	}
	
	
	
	
	
		//Save sweets
		@PostMapping("SweetManageOffer")
		public SweetsList createEmployee(@RequestBody SweetsList sss)
		{
			return this.sweetsrepository.save(sss);
		}
		
		
		
		
		
		//update the sweet information
		@PutMapping("/SweetManageOffer/{id}")
		public ResponseEntity<SweetsList> getEmployeeById(@PathVariable (value="id") Long offerId,@Validated @RequestBody SweetsList sweetsDetails)  // employeeId is the argument passed
		throws  NoOfferOnThisSweetException
		{
			SweetsList ss =sweetsrepository.findById(offerId).orElseThrow(() ->new NoOfferOnThisSweetException("offer not applicable"+offerId));
			ss.setSweetCategoryMilk(sweetsDetails.getSweetCategoryMilk());
			ss.setSweetCatgoryKaaju(sweetsDetails.getSweetCatgoryKaaju());
			ss.setSweetCtegoryGhee(sweetsDetails.getSweetCtegoryGhee());
			return ResponseEntity.ok(this.sweetsrepository.save(ss));
		}
		
		//findById(employeeId)
		

		//delete the sweets information
		@DeleteMapping("/SweetManageOffer/{id}")
		public Map<String,Boolean> deleteEmployee(@PathVariable(value="id")Long offerId)
		throws  NoOfferOnThisSweetException
		{
			SweetsList ss =sweetsrepository.findById(offerId).orElseThrow(()->new NoOfferOnThisSweetException("employee is not found by id"+offerId));
			this.sweetsrepository.delete(ss);
			Map<String,Boolean> response=new HashMap<>();
			response.put("deleted",Boolean.TRUE);
			return response;
		
		
		}
		
		
		
		
		
		
		
		
	
	
	

}
/*
if(SweetsList==sweetCategoryMilk)
{
	int offerOnMilkSweets=10;
}
else if(SweetsList==sweetCategoryGhee)
{
	int offerOnGheeSweets=20;
}
else if(SweetsList==sweetCategoryKaaju)
{
	int offerOnKaajuSweets=30;
}*/





/*package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.Exception.ResourceNotFoundException;
import com.example.demo.controller.Repositary.EmployeeRepositary;
import com.example.demo.model.Employee;

@RestController
@RequestMapping("/Employee")  //api=>application interface,v1=version 1
//you can give any value for this request mapping  example(/api/v1) 
public class EmployeeController 
{
	//call the http methods=> post,edit,delete,get
	//get employee information  id,firstname,lastname
	//get employee information with the help of id
	@Autowired
	private EmployeeRepositary employeerepositary;  		//	employeeRepositary present in another package kindly import that
	@GetMapping("employees")								//getting employee details on controller 
	public List<Employee> getEmployee()						//import list from util package  //import Employee values
	{
		return this.employeerepositary.findAll();
	}
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable (value="id") Long employeeId)  // employeeId is the argument passed
	throws ResourceNotFoundException
	{
		Employee employee = employeerepositary.findById(employeeId).orElseThrow(() ->new ResourceNotFoundException("Employee not found"+employeeId));
		return ResponseEntity.ok().body(employee);
	}
	
	//Save employees
	@PostMapping("employees")
	public Employee createEmployee(@RequestBody Employee employee)
	{
		return this.employeerepositary.save(employee);
	}
	
	
	
	//update the employee information
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable (value="id") Long employeeId,@Validated @RequestBody Employee employeeDetails)  // employeeId is the argument passed
	throws ResourceNotFoundException
	{
		Employee employee = employeerepositary.findById(employeeId).orElseThrow(() ->new ResourceNotFoundException("Employee not found"+employeeId));
		employee.setEmail(employeeDetails.getEmail());
		employee.setFirstname(employeeDetails.getFirstname());
		employee.setLastname(employeeDetails.getLastname());

		return ResponseEntity.ok(this.employeerepositary.save(employee));
	}
	
	
	
	
	
	
	//delete the employee information
	@DeleteMapping("employees/{id}")
	public Map<String,Boolean> deleteEmployee(@PathVariable(value="id")Long employeeId)
	throws ResourceNotFoundException
	{
		Employee employee =employeerepositary.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("employee is not found by id"+employeeId));
		this.employeerepositary.delete(employee);
		Map<String,Boolean> response=new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return response;
	}
	
	
}
*/




