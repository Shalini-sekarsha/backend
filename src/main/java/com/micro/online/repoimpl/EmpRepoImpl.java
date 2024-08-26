package com.micro.online.repoimpl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.micro.online.model.Emp;
import com.micro.online.repository.EmpRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EmpRepoImpl implements EmpRepo {
	@Autowired
	EntityManager em;

	@Override
	public String save(Emp emp) {
		if (emp != null) {
			em.persist(emp);
			return "success";
		}
		else {
			return "Fail to Add";
		}

	}

	@Override
	public Emp findById(int id) {

		return em.find(Emp.class, id);
	}

	@Override
	public List<Emp> findAll() {
		String hql = "from Emp";
		Query query = em.createQuery(hql);

		return query.getResultList();
	}

	@Override
	public void update(Emp emp) {
		em.merge(emp);

	}

	@Override
	public void deleteById(int id) {
		Emp emp = em.find(Emp.class, id);
		em.remove(emp);

	}

}

