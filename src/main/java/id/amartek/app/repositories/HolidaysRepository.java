package id.amartek.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.amartek.app.entities.Holidays;

@Repository
public interface HolidaysRepository extends JpaRepository<Holidays, Integer> {
    
}
