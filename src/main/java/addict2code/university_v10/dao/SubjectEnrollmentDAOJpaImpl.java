package addict2code.university_v10.dao;

import addict2code.university_v10.entity.SubjectEnrollment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class SubjectEnrollmentDAOJpaImpl implements SubjectEnrollmentDAO {
    private EntityManager entityManager;
    public SubjectEnrollmentDAOJpaImpl(EntityManager theEntityManager){
        this.entityManager = theEntityManager;
    }
    @Override
    public List<SubjectEnrollment> findAll() {
        // create query
        TypedQuery<SubjectEnrollment> query = entityManager.createQuery("SELECT suEn FROM SubjectEnrollment suEn", SubjectEnrollment.class);
        // return results
        return query.getResultList();
    }
}
