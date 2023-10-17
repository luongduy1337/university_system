package addict2code.university_v10.dao;

import addict2code.university_v10.entity.Subjects;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class SubjectsDAOJpaImpl implements SubjectsDAO {
    private EntityManager entityManager;

    public SubjectsDAOJpaImpl(EntityManager theEntityManager){
        this.entityManager = theEntityManager;
    }
    @Override
    public List<Subjects> findAll() {
        // create query

        TypedQuery<Subjects> theQuery = entityManager.createQuery("SELECT su FROM Subjects su", Subjects.class);

        // return results
        return theQuery.getResultList();
    }
}
