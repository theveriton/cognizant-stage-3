package com.cognizant.ormlearn.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

	@Query(value="SELECT e from Employee e WHERE e.permanent=1")
	List<Employee> getAllPermanentEmployees();
	
	@Query(value="SELECT AVG(e.salary) FROM Employee e WHERE e.department.id =:id")
	double getAverageSalary(@Param("id") int id);
	
	@Query(value="SELECT * FROM employee", nativeQuery=true)
	List<Employee> getAllEmployeesNative();
}
