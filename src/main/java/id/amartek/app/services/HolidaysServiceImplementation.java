package id.amartek.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.amartek.app.entities.Holidays;
import id.amartek.app.repositories.HolidaysRepository;

@Service
public class HolidaysServiceImplementation implements HolidaysService {
    @Autowired
    private HolidaysRepository holidaysRepository;

    @Override
    public List<Holidays> Get() {
        return holidaysRepository.findAll();
    }

    @Override
    public Holidays Get(Integer id) {
        return holidaysRepository.findById(id).orElseThrow(null);
    }

    @Override
    public Boolean Save(Holidays model) {
        holidaysRepository.save(model);
        return holidaysRepository.findById(model.getHolidays_id()).isPresent();
    }

    @Override
    public Boolean Delete(Integer id) {
        holidaysRepository.deleteById(id);
        return !holidaysRepository.findById(id).isPresent();
    }
}
