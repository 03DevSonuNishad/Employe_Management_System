package com.root.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.root.entity.Employe;
import com.root.repository.EmployeRepo;

import jakarta.servlet.http.HttpSession;

@Service
public class EmployeServiceImpl implements EmployeService {

	@Autowired
	private EmployeRepo empRepo;

	@Override
	public Employe saveEmp(Employe emp) {

		Employe newEmp = empRepo.save(emp);

		return newEmp;
	}

	@Override
	public List<Employe> getAllEmp() {

		return empRepo.findAll();
	}

	@Override
	public Employe getEmpById(int id) {

		return empRepo.findById(id).get();
	}

	@Override
	public boolean deleteEmp(int id) {

		Employe emp = empRepo.findById(id).get();

		if (emp != null) {

			empRepo.delete(emp);
			return true;
		}
		return false;
	}

	public void removeSessionMessage() {

		HttpSession session = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest()
				.getSession();

		session.removeAttribute("msg");
	}

}
