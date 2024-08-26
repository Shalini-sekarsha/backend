package com.micro.online.serviceimpl;






import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.online.model.Emp;
import com.micro.online.repository.EmpRepo;
import com.micro.online.service.EmpService;



@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
    EmpRepo repo;
	
	public String addEmp(Emp emp) {
		return repo.save(emp);
	}

	public Emp getEmp(int id) {
		
		return repo.findById(id) ;
	}
 
public List<Emp> getAllEmp(){
	return repo.findAll();
}


public void updateEmp(Emp emp) {
	repo.update(emp);
}	
public void deleteEmp(int id) {
	repo.deleteById(id);
}
}
