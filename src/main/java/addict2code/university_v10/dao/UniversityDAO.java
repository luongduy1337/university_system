package addict2code.university_v10.dao;

import addict2code.university_v10.dto.CreateStudentDTO;
import addict2code.university_v10.dto.CreateUniversityDTO;
import addict2code.university_v10.dto.UpdateStudentDTO;
import addict2code.university_v10.dto.UpdateUniversityDTO;
import addict2code.university_v10.entity.University;

import java.util.List;

public interface UniversityDAO {
    List<University> findAll();

    University findOne(int universityId);

    void add(CreateUniversityDTO createUniversityDTO);

    void update(UpdateUniversityDTO updateUniversityDTO);

    void delete(int universityId);
}
