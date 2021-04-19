package in.kartik.repo;

import in.kartik.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
@Repository
public interface EmpRepository extends JpaRepository<Employee, Serializable> {

}
