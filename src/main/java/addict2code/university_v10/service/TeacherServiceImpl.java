package addict2code.university_v10.service;

import addict2code.university_v10.dao.TeacherDAO;
import addict2code.university_v10.dto.CreateTeacherDTO;
import addict2code.university_v10.dto.UpdateTeacherDTO;
import addict2code.university_v10.entity.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeacherServiceImpl implements TeacherService {
    private TeacherDAO teacherDAO;

    public TeacherServiceImpl(TeacherDAO theTeacherDAO){
        this.teacherDAO = theTeacherDAO;
    }
    @Override
    public List<Teacher> findAll() {
        return teacherDAO.findAll();
    }

    @Override
    public Teacher findOne(int teacherId) {
        return teacherDAO.findOne(teacherId);
    }

    @Override
    public void add(CreateTeacherDTO createTeacherDTO) {
        teacherDAO.add(createTeacherDTO);

    }

    @Override
    public void update(UpdateTeacherDTO updateTeacherDTO) {
        teacherDAO.update(updateTeacherDTO);
    }

    @Override
    public void delete(int teacherId) {
        teacherDAO.delete(teacherId);
    }
}
