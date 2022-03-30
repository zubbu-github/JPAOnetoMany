package com.cg.jpastart.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OneToManyDemo {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		
		//create a new department
		Department department = new Department();
		department.setId(40);
		department.setName("Sales");
		
		Department department1 = new Department();
		department1.setId(12);
		department1.setName("Marketing");
		
		//create two instances of employees
		Employee e1 = new Employee();
		e1.setId(105);
		e1.setName("Mohammed Zubeir");
		e1.setSalary(45000);
		
		Employee e2 = new Employee();
		e2.setId(106);
		e2.setName("Gautam Gambhir");
		e2.setSalary(55000);
		
		//add both employees to department
		department.addEmployee(e1);
		department.addEmployee(e2);
		//department1.addEmployee(e1);
		
		//save department and its employees using entity manager
		em.persist(department);
		em.persist(department1);
		
		System.out.println("Added department along with two employees to database.");
		
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
}
