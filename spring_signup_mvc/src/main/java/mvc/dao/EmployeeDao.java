package mvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

import mvc.dto.Employee;

@Component
public class EmployeeDao {

	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();

	public void saveEmployee(Employee emp) {
		entityTransaction.begin();
		entityManager.persist(emp);
		entityTransaction.commit();

	}

	public Employee login(String email) {
		List<Employee> list= entityManager.createQuery("select x from Employee x where email=?1").setParameter(1, email).getResultList();
		if(list.isEmpty())
		{
			return null;
		}
		else
		{
			return list.get(0);
		}
	}

	public List<Employee> fetchAll()
	{
		return entityManager.createQuery("select x from Employee x").getResultList();
	}

	public void delete(int id) {
		entityTransaction.begin();
		entityManager.remove(find(id));
		entityTransaction.commit();
		
	}
	
	public Employee find(int id){
		return entityManager.find(Employee.class, id);
	}

	public void edit(Employee employee) {
		entityTransaction.begin();
		entityManager.merge(employee);
		entityTransaction.commit();
		
	}

}
