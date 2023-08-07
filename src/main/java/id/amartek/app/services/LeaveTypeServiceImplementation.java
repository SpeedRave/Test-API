package id.amartek.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.amartek.app.entities.LeaveType;
import id.amartek.app.repositories.LeaveTypeRepository;

@Service
public class LeaveTypeServiceImplementation implements LeaveTypeService {
    @Autowired
    private LeaveTypeRepository leaveTypeRepository;

    @Override
    public List<LeaveType> Get() {
        return leaveTypeRepository.findAll();
    }

    @Override
    public LeaveType Get(Integer id) {
        return leaveTypeRepository.findById(id).orElseThrow(null);
    }

    @Override
    public Boolean Save(LeaveType model) {
        leaveTypeRepository.save(model);
        return leaveTypeRepository.findById(model.getLeave_type_id()).isPresent();
    }

    @Override
    public Boolean Delete(Integer id) {
        leaveTypeRepository.deleteById(id);
        return !leaveTypeRepository.findById(id).isPresent();
    }    
}
