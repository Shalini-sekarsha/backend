package com.micro.online.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.micro.online.model.Emp;
@Service
public interface EmpService {
public String addEmp(Emp emp);
public Emp getEmp(int id);
public List<Emp> getAllEmp();
void updateEmp(Emp emp);
public void deleteEmp(int id);
}
