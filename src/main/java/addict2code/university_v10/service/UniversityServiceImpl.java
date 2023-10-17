package addict2code.university_v10.service;

import addict2code.university_v10.dao.UniversityDAO;
import addict2code.university_v10.dto.CreateUniversityDTO;
import addict2code.university_v10.dto.UpdateUniversityDTO;
import addict2code.university_v10.entity.University;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UniversityServiceImpl implements UniversityService {
    private UniversityDAO universityDAO;

    public UniversityServiceImpl(UniversityDAO theUniversityDAO){
        this.universityDAO = theUniversityDAO;
    }
    @Override
    public List<University> findAll() {
        return universityDAO.findAll();
    }

    @Override
    public University findOne(int universityId) {
        return universityDAO.findOne(universityId);
    }

    @Override
    public void add(CreateUniversityDTO createUniversityDTO) {
        universityDAO.add(createUniversityDTO);
    }

    @Override
    public void update(UpdateUniversityDTO updateUniversityDTO) {
        universityDAO.update(updateUniversityDTO);
    }

    @Override
    public void delete(int universityId) {
        universityDAO.delete(universityId);
    }
}
