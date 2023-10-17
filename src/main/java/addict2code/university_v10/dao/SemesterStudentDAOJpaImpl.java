package addict2code.university_v10.dao;

import addict2code.university_v10.dto.CreateSemesterStudentDTO;
import addict2code.university_v10.dto.UpdateSemesterStudentDTO;
import addict2code.university_v10.entity.SemesterStudent;
import addict2code.university_v10.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class SemesterStudentDAOJpaImpl implements SemesterStudentDAO {
    private EntityManager entityManager;

    private StudentDAO studentDAO;

    public SemesterStudentDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.studentDAO = studentDAO;
    }



    @Override
    public List<SemesterStudent> findAll() {
        TypedQuery<SemesterStudent> query = entityManager.createQuery("SELECT sestu FROM SemesterStudent sestu", SemesterStudent.class);
        return query.getResultList();
    }


    public long calculateCountForStudent(int studentId) {
        TypedQuery<Long> query = entityManager.createQuery("SELECT COUNT(sestu) FROM SemesterStudent sestu WHERE sestu.studentId=:studentId", Long.class);
        query.setParameter("studentId", studentId);

        return query.getSingleResult();
    }

    @Override
    public List<SemesterStudent> findByStudent(int studentId) {
        TypedQuery<SemesterStudent> query = entityManager.createQuery("SELECT sestu FROM SemesterStudent sestu WHERE sestu.studentId=:studentId", SemesterStudent.class);
        query.setParameter("studentId", studentId);

        List<SemesterStudent> semesterStudent = query.getResultList();
        int count = (int) calculateCountForStudent(studentId); // Tính toán COUNT ở đây nếu cần
        System.out.print("count" + count);

        return semesterStudent;
    }

    @Override
    public List<SemesterStudent> findBySemester(int semesterId) {
        TypedQuery<SemesterStudent> query = entityManager.createQuery("SELECT sestu FROM SemesterStudent sestu WHERE sestu.semesterId=:semesterId", SemesterStudent.class);
        query.setParameter("semesterId", semesterId);
        return query.getResultList();
    }

    @Override
    public SemesterStudent findOne(int semesterId, int studentId) {
        TypedQuery<SemesterStudent> query = entityManager.createQuery("SELECT sestu FROM SemesterStudent sestu WHERE sestu.semesterId=:semesterId AND sestu.studentId=:studentId", SemesterStudent.class);
        query.setParameter("semesterId", semesterId);
        query.setParameter("studentId", studentId);
        return query.getSingleResult();
    }



    @Transactional
    @Override
    public void delete(int semesterId, int studentId) {
        SemesterStudent semesterStudentDeleted = this.findOne(semesterId, studentId);
        semesterStudentDeleted.setIsDelete(1);
        entityManager.persist(semesterStudentDeleted);
    }


    @Override
    public void add(CreateSemesterStudentDTO createSemesterStudentDTO) {
        int studentId = createSemesterStudentDTO.getStudentId();
        Student studentInfo = studentDAO.findOne(studentId);
        System.out.print("studentInfo" + studentInfo);
//        newSemesterStudent.setStudentId(createSemesterStudentDTO.getStudentId());
//        entityManager.persist(newSemesterStudent);

    }

    @Transactional
    @Override
    public void update(UpdateSemesterStudentDTO updateSemesterStudentDTO, int semesterId, int studentId) {
        SemesterStudent semesterStudentUpdated = this.findOne(semesterId, studentId);
        System.out.print("before update" +semesterStudentUpdated);
        semesterStudentUpdated.setStudentId(updateSemesterStudentDTO.getStudentId());
        semesterStudentUpdated.setSemesterId(updateSemesterStudentDTO.getSemesterId());
        System.out.print("after update" + semesterStudentUpdated);
        entityManager.persist(semesterStudentUpdated);
    }


}
