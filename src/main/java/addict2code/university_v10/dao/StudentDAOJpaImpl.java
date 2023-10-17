package addict2code.university_v10.dao;

import addict2code.university_v10.dto.CreateStudentDTO;
import addict2code.university_v10.dto.UpdateStudentDTO;
import addict2code.university_v10.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.util.List;
@Repository
public class StudentDAOJpaImpl implements StudentDAO {

    private final EntityManager entityManager;


    // initialize constructor
    public StudentDAOJpaImpl(EntityManager theEntityManager){
        this.entityManager = theEntityManager;
    }
    @Override
    public List<Student> findAll() {
        // create query to get all student
        TypedQuery<Student> theQuery = entityManager.createQuery("SELECT st FROM Student st WHERE st.isDelete = 0", Student.class);

        // return result after querying
        return theQuery.getResultList();

    }

    @Override
    public Student findOne(int studentId) {
        // create query to get one student
        TypedQuery<Student> theQuery = entityManager.createQuery("SELECT st FROM Student st WHERE st.studentId=:studentId AND st.isDelete = 0", Student.class);

        // add parameter into query

        theQuery.setParameter("studentId", studentId);

        // return result after querying
        return theQuery.getSingleResult();
    }

    @Override
    @Transactional
    public void add(CreateStudentDTO createStudentDTO) {
        Student newStudent = new Student();
        newStudent.setFirstName(createStudentDTO.getFirstName());
        newStudent.setLastName(createStudentDTO.getLastName());
        newStudent.setStreetNumber(createStudentDTO.getStreetNumber());
        newStudent.setStreetName(createStudentDTO.getStreetName());
        newStudent.setSuburb(createStudentDTO.getSuburb());
        newStudent.setCity(createStudentDTO.getCity());
        newStudent.setDateOfBirth(createStudentDTO.getDateOfBirth());
        newStudent.setState(createStudentDTO.getState());
        newStudent.setCountry(createStudentDTO.getCountry());
        entityManager.persist(newStudent);
    }

    @Transactional
    @Override
    public void update(UpdateStudentDTO updateStudentDTO) {
        int studentId = updateStudentDTO.getStudentId();
        Student studentUpdated = this.findOne(studentId);
        studentUpdated.setFirstName(updateStudentDTO.getFirstName());
        studentUpdated.setLastName(updateStudentDTO.getLastName());
        studentUpdated.setDateOfBirth(updateStudentDTO.getDateOfBirth());
        studentUpdated.setStreetNumber(updateStudentDTO.getStreetNumber());
        studentUpdated.setStreetName(updateStudentDTO.getStreetName());
        studentUpdated.setSuburb(updateStudentDTO.getSuburb());
        studentUpdated.setCity(updateStudentDTO.getCity());
        studentUpdated.setState(updateStudentDTO.getState());
        studentUpdated.setCountry(updateStudentDTO.getCountry());

    }

    @Override
    @Transactional
    public void delete(int studentId) {
        Student studentDeleted = this.findOne(studentId);
        studentDeleted.setIsDelete(1);
    }

    @Override
    public List<Student> findAllWithSubjects(int subjectId) {
        // create query
        TypedQuery<Student> query = entityManager.createQuery("SELECT st FROM Student st JOIN st.subjects su WHERE su.subjectId = :subjectId", Student.class);
        // pass parameters
        query.setParameter("subjectId", subjectId);
        return query.getResultList();
    }

    @Override
    public List<Student> findByFirstName(String firstName) {
        // create a query
        TypedQuery<Student> query = entityManager.createQuery("SELECT st FROM Student st WHERE st.firstName LIKE :firstName AND st.isDelete=0", Student.class);

        // add parameter
        query.setParameter("firstName", firstName + "%");

        // return results
        return query.getResultList();
    }


}
