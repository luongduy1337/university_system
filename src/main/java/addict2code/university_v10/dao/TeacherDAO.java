package addict2code.university_v10.dao;

import addict2code.university_v10.dto.CreateTeacherDTO;
import addict2code.university_v10.dto.UpdateTeacherDTO;
import addict2code.university_v10.entity.Teacher;

import java.util.List;

public interface TeacherDAO {
    List<Teacher> findAll();

    Teacher findOne(int teacherId);

    void add(CreateTeacherDTO createTeacherDTO);

    void update(UpdateTeacherDTO updateTeacherDTO);

    void delete(int teacherId);
}
