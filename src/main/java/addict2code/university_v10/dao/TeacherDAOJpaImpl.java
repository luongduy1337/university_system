package addict2code.university_v10.dao;

import addict2code.university_v10.dto.CreateTeacherDTO;
import addict2code.university_v10.dto.UpdateTeacherDTO;
import addict2code.university_v10.entity.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TeacherDAOJpaImpl implements TeacherDAO {
    private EntityManager entityManager;

    public TeacherDAOJpaImpl(EntityManager theEntityManager){
        this.entityManager = theEntityManager;
    }
    @Override
    public List<Teacher> findAll() {
        TypedQuery<Teacher> query = entityManager.createQuery("SELECT te FROM Teacher te WHERE te.isDelete = 0", Teacher.class);
        return query.getResultList();
    }

    @Override
    public Teacher findOne(int teacherId) {
        TypedQuery<Teacher> query = entityManager.createQuery("SELECT te FROM Teacher te WHERE te.teacherId=:teacherId AND te.isDelete = 0", Teacher.class);
        query.setParameter("teacherId", teacherId);
        return query.getSingleResult();
    }

    @Transactional
    @Override
    public void add(CreateTeacherDTO createTeacherDTO) {
        Teacher newTeacher = new Teacher();
        newTeacher.setFirstName(createTeacherDTO.getFirstName());
        newTeacher.setLastName(createTeacherDTO.getLastName());
        newTeacher.setCity(createTeacherDTO.getCity());
        newTeacher.setCountry(createTeacherDTO.getCountry());
        newTeacher.setSuburb(createTeacherDTO.getSuburb());
        newTeacher.setState(createTeacherDTO.getState());
        newTeacher.setDateOfBirth(createTeacherDTO.getDateOfBirth());
        newTeacher.setStreetNumber(createTeacherDTO.getStreetNumber());
        newTeacher.setStreetName(createTeacherDTO.getStreetName());
        newTeacher.setIsDelete(0);
        entityManager.persist(newTeacher);
    }

    @Transactional
    @Override
    public void update(UpdateTeacherDTO updateTeacherDTO) {
        int teacherId = updateTeacherDTO.getTeacherId();
        Teacher teacherUpdated = this.findOne(teacherId);
        teacherUpdated.setFirstName(updateTeacherDTO.getFirstName());
        teacherUpdated.setLastName(updateTeacherDTO.getLastName());
        teacherUpdated.setCity(updateTeacherDTO.getCity());
        teacherUpdated.setCountry(updateTeacherDTO.getCountry());
        teacherUpdated.setSuburb(updateTeacherDTO.getSuburb());
        teacherUpdated.setState(updateTeacherDTO.getState());
        teacherUpdated.setDateOfBirth(updateTeacherDTO.getDateOfBirth());
        teacherUpdated.setStreetNumber(updateTeacherDTO.getStreetNumber());
        teacherUpdated.setStreetName(updateTeacherDTO.getStreetName());
        entityManager.persist(teacherUpdated);
    }

    @Transactional
    @Override
    public void delete(int teacherId) {
        Teacher teacherDeleted = this.findOne(teacherId);
        teacherDeleted.setIsDelete(1);

    }
}
