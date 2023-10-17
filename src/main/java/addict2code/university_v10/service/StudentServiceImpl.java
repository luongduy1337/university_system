package addict2code.university_v10.service;

import addict2code.university_v10.dao.StudentDAO;
import addict2code.university_v10.dto.CreateStudentDTO;
import addict2code.university_v10.dto.UpdateStudentDTO;
import addict2code.university_v10.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    private StudentDAO studentDAO;

    // initialize constructor
    @Autowired
    public StudentServiceImpl(StudentDAO theStudentDAO){
        this.studentDAO = theStudentDAO;
    }
    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    public Student findOne(int studentId) {
        return studentDAO.findOne(studentId);
    }

    @Override
    public void add(CreateStudentDTO createStudentDTO) {
        studentDAO.add(createStudentDTO);
    }

    @Override
    public void update(UpdateStudentDTO updateStudentDTO) {
        studentDAO.update(updateStudentDTO);
    }

    @Override
    public void delete(int studentId) {
        studentDAO.delete(studentId);
    }

    @Override
    public List<Student> findAllWithSubjects(int subjectId) {
        return studentDAO.findAllWithSubjects(subjectId);
    }

    @Override
    public List<Student> findByFirstName(String firstName) {
        return studentDAO.findByFirstName(firstName);
    }
}
