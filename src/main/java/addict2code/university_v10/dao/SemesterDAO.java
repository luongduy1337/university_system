package addict2code.university_v10.dao;

import addict2code.university_v10.dto.CreateSemesterDTO;
import addict2code.university_v10.dto.UpdateSemesterDTO;
import addict2code.university_v10.entity.Semester;

import java.util.List;

public interface SemesterDAO {
    List<Semester> findAll();

    Semester findOne(int semesterId);

    void add(CreateSemesterDTO createSemesterDTO);

    void update(UpdateSemesterDTO updateSemesterDTO);

    void delete(int semesterId);

    List<Semester> findByCodeName(String semesterCode);
}
