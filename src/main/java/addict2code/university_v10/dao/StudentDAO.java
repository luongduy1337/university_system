package addict2code.university_v10.dao;

import addict2code.university_v10.dto.CreateStudentDTO;
import addict2code.university_v10.dto.UpdateStudentDTO;
import addict2code.university_v10.entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.util.List;
@Qualifier("myStudentDAO")
public interface StudentDAO {
    List<Student> findAll();


    Student findOne(int studentId);

    void add(CreateStudentDTO createStudentDTO);

    void update(UpdateStudentDTO updateStudentDTO);

    void delete(int studentId);

    List<Student> findAllWithSubjects(int subjectId);

    List<Student> findByFirstName(String firstName);


}
