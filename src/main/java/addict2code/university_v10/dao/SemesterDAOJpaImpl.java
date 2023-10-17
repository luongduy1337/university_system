package addict2code.university_v10.dao;

import addict2code.university_v10.dto.CreateSemesterDTO;
import addict2code.university_v10.dto.UpdateSemesterDTO;
import addict2code.university_v10.entity.Semester;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SemesterDAOJpaImpl implements SemesterDAO {
    private EntityManager entityManager;

    public SemesterDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Semester> findAll() {
        TypedQuery<Semester> query = entityManager.createQuery("SELECT se FROM Semester se", Semester.class);
        return query.getResultList();
    }

    @Override
    public Semester findOne(int semesterId) {
        TypedQuery<Semester> query = entityManager.createQuery("SELECT se FROM Semester se WHERE se.semesterId=:semesterId", Semester.class);
        query.setParameter("semesterId", semesterId);
        return query.getSingleResult();
    }

    @Transactional
    @Override
    public void add(CreateSemesterDTO createSemesterDTO) {
        Semester newSemester = new Semester();
        newSemester.setSemesterName(createSemesterDTO.getSemesterName());
        newSemester.setSemesterCode(createSemesterDTO.getSemesterCode());
        newSemester.setIsDelete(0);
        entityManager.persist(newSemester);
    }


    @Transactional
    @Override
    public void update(UpdateSemesterDTO updateSemesterDTO) {
        int semesterId = updateSemesterDTO.getSemesterId();
        Semester semesterUpdated = this.findOne(semesterId);
        semesterUpdated.setSemesterName(updateSemesterDTO.getSemesterName());
        semesterUpdated.setSemesterCode(updateSemesterDTO.getSemesterCode());
        entityManager.persist(semesterUpdated);
    }

    @Transactional
    @Override
    public void delete(int semesterId) {
        Semester semesterDeleted = this.findOne(semesterId);
        semesterDeleted.setIsDelete(1);
        entityManager.persist(semesterDeleted);

    }

    @Override
    public List<Semester> findByCodeName(String semesterCode) {
        // create a query
        TypedQuery<Semester> query = entityManager.createQuery("SELECT se FROM Semester se WHERE se.semesterCode LIKE :semesterCode", Semester.class);

        // add parameter
        query.setParameter("semesterCode", "%" + semesterCode + "%" );

        // return results
        return query.getResultList();
    }
}
