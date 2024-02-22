package hibernate_employee.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hibernate_employee.dto.Employee;

public class EmployeeDao 
{
	Employee employee=new Employee();
	
	public EntityManager getEntityManager()
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Priti");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		return entityManager;
	}
	
	public void saveEmployee(Employee employee)
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		System.out.println("added sucessfully");
	}
	public void fetchEmployee(int id)
	{
		EntityManager entityManager=getEntityManager();
		Employee employee=entityManager.find(Employee.class, 1);
		if(employee!=null)
		{
			System.out.println(employee);
		}
		else
		{
			System.out.println("not found");
		}
	}
	public void updateEmployee(Employee employee)
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Employee dbemployee=entityManager.find(Employee.class, 1);
		if(dbemployee!=null)
		{
			entityTransaction.begin();
			entityManager.persist(dbemployee);
			entityTransaction.commit();
		}
		else
		{
			System.out.println("not found");
		}
	}
	public void deleteEmployee(int id)
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
        Employee dbbemployee=entityManager.find(Employee.class, id);
		
		if(dbbemployee!=null)
		{
			entityTransaction.begin();
			entityManager.remove(dbbemployee);
			entityTransaction.commit();
			System.out.println("employee deleted sucessfully");
		}
		else
		{
			System.out.println("employee not found");
		}
	}
	public void getAllEmployee()
	{
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("select e from Employee e");
		List<Employee> list=query.getResultList();
		System.out.println(list);
	}
}
