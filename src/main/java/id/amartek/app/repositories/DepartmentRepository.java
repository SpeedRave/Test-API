package id.amartek.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.amartek.app.entities.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    
}
