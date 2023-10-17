package addict2code.university_v10.service;

import addict2code.university_v10.dao.MajorDAO;
import addict2code.university_v10.dto.CreateMajorDTO;
import addict2code.university_v10.dto.UpdateMajorDTO;
import addict2code.university_v10.entity.Major;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MajorServiceImpl implements MajorService {
    private MajorDAO majorDAO;

    public MajorServiceImpl(MajorDAO theMajorDAO){
        this.majorDAO = theMajorDAO;
    }
    @Override
    public List<Major> findAll() {
        return majorDAO.findAll();
    }

    @Override
    public Major findOne(int majorId) {
        return majorDAO.findOne(majorId);
    }

    @Override
    public void add(CreateMajorDTO createMajorDTO) {
        majorDAO.add(createMajorDTO);
    }

    @Override
    public void update(UpdateMajorDTO updateMajorDTO) {
        majorDAO.update(updateMajorDTO);
    }

    @Override
    public void delete(int majorId) {
        majorDAO.delete(majorId);

    }
}
