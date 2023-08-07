package id.amartek.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.amartek.app.entities.LeaveType;

@Repository
public interface LeaveTypeRepository extends JpaRepository<LeaveType, Integer> {
    
}
