package id.amartek.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.amartek.app.entities.Leave;

@Repository
public interface LeaveRepository extends JpaRepository<Leave, Integer> {
    
}
