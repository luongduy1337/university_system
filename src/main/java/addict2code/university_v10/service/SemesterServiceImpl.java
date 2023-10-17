package addict2code.university_v10.service;

import addict2code.university_v10.dao.SemesterDAO;
import addict2code.university_v10.dto.CreateSemesterDTO;
import addict2code.university_v10.dto.UpdateSemesterDTO;
import addict2code.university_v10.entity.Semester;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SemesterServiceImpl implements SemesterService {
    private SemesterDAO semesterDAO;


    public SemesterServiceImpl(SemesterDAO semesterDAO) {
        this.semesterDAO = semesterDAO;
    }

    @Override
    public List<Semester> findAll() {
        return semesterDAO.findAll();
    }

    @Override
    public Semester findOne(int semesterId) {
        return semesterDAO.findOne(semesterId);
    }

    @Override
    public void add(CreateSemesterDTO createSemesterDTO) {
        semesterDAO.add(createSemesterDTO);
    }

    @Override
    public void update(UpdateSemesterDTO updateSemesterDTO) {
        semesterDAO.update(updateSemesterDTO);
    }

    @Override
    public void delete(int semesterId) {
        semesterDAO.delete(semesterId);
    }

    @Override
    public List<Semester> findByCodeName(String semesterCode) {
        return semesterDAO.findByCodeName(semesterCode);
    }
}
