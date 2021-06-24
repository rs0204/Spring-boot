package com.nagarro.hrmanager.dao;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	    //field for entity manager
		private EntityManager entityManager;

		//set up constructor injection
		@Autowired
		public EmployeeDaoImpl(EntityManager theEntityManager) {
			entityManager=theEntityManager;
		}

	@Override
	public void deleteById(int employeeCode) {
     Session currentSession=entityManager.unwrap(Session.class);
		
		@SuppressWarnings("rawtypes")
		Query theQuery=currentSession.createQuery(
				"delete from Employee where employee_code=:employeeCode");
		
		theQuery.setParameter("employeeCode", employeeCode);
		
		theQuery.executeUpdate();

	}

}
