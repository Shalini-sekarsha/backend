package com.micro.online.repository;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.micro.online.model.Emp;



@Repository
public interface EmpRepo{

	String save(Emp emp);

	Emp findById(int id);

	List<Emp> findAll();

	void update(Emp emp);

	void deleteById(int id);

}

	


