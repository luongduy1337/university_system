package addict2code.university_v10.dao;

import addict2code.university_v10.dto.CreateSemesterStudentDTO;
import addict2code.university_v10.dto.UpdateSemesterStudentDTO;
import addict2code.university_v10.entity.SemesterStudent;

import java.util.List;

public interface SemesterStudentDAO {
    List<SemesterStudent> findAll();

    List<SemesterStudent> findByStudent(int studentId);

    List<SemesterStudent> findBySemester(int semesterId);

    void add(CreateSemesterStudentDTO createSemesterStudentDTO);

    void update(UpdateSemesterStudentDTO updateSemesterStudentDTO, int semesterId, int studentId);

    SemesterStudent findOne(int semesterId, int studentId);

    void delete(int semesterId, int studentId);

}
