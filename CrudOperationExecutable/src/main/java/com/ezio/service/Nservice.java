package com.ezio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezio.model.Nmodel;
import com.ezio.repository.Nrepository;

@Service
public class Nservice 
{

	@Autowired 
	Nrepository repository;
	
	public List<Nmodel> getAllEmployees()
	{
	
		return repository.findAll();
	}
	public void saveEmployee(Nmodel employee) 
	{
	this.repository.save(employee);
		
	}
	public Nmodel getEmployeeById(long id) {
		Optional<Nmodel> optional=repository.findById(id);
		Nmodel employee=null;
			if(optional.isPresent())
				{
					employee=optional.get();
				}
			else
				{
					throw new RuntimeException("employee not found"+id);
				}
			return employee;
	}
	public Nmodel deleteEmployeeByID(Long id) 
	{
		this.repository.deleteById(id);
		Nmodel employee = null;
		return employee;
	
	}
	
}


