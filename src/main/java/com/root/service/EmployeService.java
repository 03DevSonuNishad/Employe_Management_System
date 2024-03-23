package com.root.service;

import java.util.List;

import com.root.entity.Employe;

public interface EmployeService {

	// that is Save the Employe all data and update
	public Employe saveEmp(Employe emp);

	// that is fatched the employe data from the database
	public List<Employe> getAllEmp();

	// that is fatched the employe data with the help of id
	public Employe getEmpById(int id);

	// that is delete the data from the employe database
	public boolean deleteEmp(int id);
}
