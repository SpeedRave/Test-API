package id.amartek.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.amartek.app.entities.Leave;
import id.amartek.app.repositories.LeaveRepository;

@Service
public class LeaveServiceImplementation implements LeaveService {
    @Autowired
    private LeaveRepository leaveRepository;

    @Override
    public List<Leave> Get() {
        return leaveRepository.findAll();
    }

    @Override
    public Leave Get(Integer id) {
        return leaveRepository.findById(id).orElseThrow(null);
    }

    @Override
    public Boolean Save(Leave model) {
        leaveRepository.save(model);
        return leaveRepository.findById(model.getLeave_id()).isPresent();
    }

    @Override
    public Boolean Delete(Integer id) {
        leaveRepository.deleteById(id);
        return !leaveRepository.findById(id).isPresent();
    }
}
