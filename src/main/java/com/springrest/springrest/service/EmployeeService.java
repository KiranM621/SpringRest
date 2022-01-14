package com.springrest.springrest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.EmployeeDao;
import com.springrest.springrest.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	
//	List<Employee> list;
	
	
	
	
	/*
	 * public EmployeeService() { list = new ArrayList<Employee>(); list.add(new
	 * Employee(1,"kiran","M","Tester")); list.add(new
	 * Employee(2,"Liam","M","Dev"));
	 * 
	 * }
	 */




	public List<Employee> getData() {
	
//		System.out.println(list);
		return this.employeeDao.findAll();
		
	}




	public Employee getById(int id) {

		/*
		 * Employee employee = null;
		 * 
		 * for(Employee e : list) { if(e.getId() == id) { employee=e; break; }
		 * 
		 * }
		 */
		
		
		return employeeDao.findById(id).get();
	}




	public Employee create(Employee employee) {
		
		/*
		 * boolean e = list.add(employee);
		 */
		employeeDao.save(employee);
		return employee;
	}




	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
		/*
		 * Employee employee = null; boolean result = false; for(Employee e : list) {
		 * 
		 * if(e.getId()==id) { employee = e; result = list.remove(employee); break; }
		 * 
		 * }
		 */
		
		Employee entity = employeeDao.getOne(id);
		employeeDao.delete(entity);
	}




	public Employee updateById(int id, Employee employee) {

		/*
		 * int index = 0 ; Employee emp = null; for(Employee e : list) {
		 * 
		 * if(e.getId()==id) { index = list.indexOf(e); break; }
		 * 
		 * } list.set(index, employee); emp = list.get(index);
		 */
		Employee data = employeeDao.getOne(id);
		employeeDao.save(data);
		
		return employee;
	}

	
	
	
}
