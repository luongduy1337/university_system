package addict2code.university_v10.service;

import addict2code.university_v10.dao.SemesterStudentDAO;
import addict2code.university_v10.dao.StudentDAO;
import addict2code.university_v10.dto.CreateSemesterStudentDTO;
import addict2code.university_v10.dto.UpdateSemesterStudentDTO;
import addict2code.university_v10.entity.SemesterStudent;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SemesterStudentServiceImpl implements SemesterStudentService {
    private SemesterStudentDAO semesterStudentDAO;

    public SemesterStudentServiceImpl(SemesterStudentDAO semesterStudentDAO) {
        this.semesterStudentDAO = semesterStudentDAO;
    }

    @Override
    public List<SemesterStudent> findAll() {
        return semesterStudentDAO.findAll();
    }

    @Override
    public List<SemesterStudent> findByStudent(int studentId) {
        return semesterStudentDAO.findByStudent(studentId);
    }

    @Override
    public List<SemesterStudent> findBySemester(int semesterId) {
        return semesterStudentDAO.findBySemester(semesterId);
    }

    @Override
    public void add(CreateSemesterStudentDTO createSemesterStudentDTO) {
        semesterStudentDAO.add(createSemesterStudentDTO);
    }

    @Override
    public SemesterStudent findOne(int semesterId, int studentId) {
        return semesterStudentDAO.findOne(semesterId, studentId);
    }

    @Override
    public void update(UpdateSemesterStudentDTO updateSemesterStudentDTO, int semesterId, int studentId) {
        semesterStudentDAO.update(updateSemesterStudentDTO, semesterId, studentId);
    }

    @Override
    public void delete(int semesterId, int studentId) {
        semesterStudentDAO.delete(semesterId, studentId);
    }

}
