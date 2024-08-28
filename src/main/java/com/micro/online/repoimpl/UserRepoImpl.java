package com.micro.online.repoimpl;
 

 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.micro.online.model.User;
import com.micro.online.repository.UserRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
 
@Repository
public class UserRepoImpl implements UserRepo {
 
	@Autowired
	EntityManager entityMan;
 
	@Override
	public User insertUser(User newUser) {
		entityMan.merge(newUser);
		return newUser;
	}
//	@Override
//	public User findByuserNameAnduserPassword(String userName, String userPassword) {
//		String jpql = "SELECT a FROM User a WHERE a.userName = :userName AND a.userPassword = :userPassword";
//		TypedQuery<User> query = entityMan.createQuery(jpql, User.class);
//		query.setParameter("userName", userName);
//		query.setParameter("userPassword", userPassword);
//		return query.getResultStream().findFirst().orElse(null);
//	}
// 
	@Override
	public User updateUser(User user) {
		entityMan.merge(user);
		return user;
	}
 
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers() {
		return entityMan.createQuery("from User").getResultList();
 
	}
 
	@Override
	public User userfind(int userId) {
		return entityMan.find(User.class, userId);
 
	}
 
	@Override
	public User findUserByUserEmail(String userEmail) {
		return entityMan.find(User.class, userEmail);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getUserIdlist() {
		Query q = entityMan.createQuery("SELECT c.userId FROM User c");
		return q.getResultList();
 
	}
 
	@SuppressWarnings("unchecked")
	public List<User> searchUser(String userName) {
		Query qry2 = entityMan.createQuery("from User u where u.userName=?1");
		qry2.setParameter(1, userName);
		return qry2.getResultList();
	}
	public User userLogin(String userName, String userPassword) {
	    Query query = entityMan.createQuery("from User u where u.userName = :userName and u.userPassword = :userPassword");
	    query.setParameter("userName", userName);
	    query.setParameter("userPassword", userPassword);
	    List<User> results = query.getResultList();
	    if (results.isEmpty()) {
	        return null; // Or handle it in another appropriate way
	    }
	    return results.get(0); // Return the first result if available
	}
	@Override
	public User findByuserName(String userName) {
		 String jpql = "SELECT u FROM User u WHERE u.userName = :userName";
		    TypedQuery<User> query = entityMan.createQuery(jpql, User.class);
		    query.setParameter("userName", userName);
		    
		    try {
		        return query.getSingleResult();
		    } catch (NoResultException | NonUniqueResultException e) {
		        return null;
		    }
	}
	

	

}