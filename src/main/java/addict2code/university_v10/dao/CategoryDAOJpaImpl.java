package addict2code.university_v10.dao;

import addict2code.university_v10.entity.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDAOJpaImpl implements CategoryDAO {

    private EntityManager entityManager;

    // initialize constructor

    public CategoryDAOJpaImpl(EntityManager theEntityManager){
        this.entityManager = theEntityManager;
    }
    @Override
    public List<Category> findAll() {
        // create query (join 2 table)
        TypedQuery<Category> theQuery = entityManager.createQuery("SELECT ca FROM Category ca", Category.class);

        // return results
        return theQuery.getResultList();

    }

    @Override
    public Category findOne(int category_id) {
        // create query (join 2 table)
        TypedQuery<Category> theQuery = entityManager.createQuery("SELECT ca FROM Category LEFT JOIN ca.subject_id WHERE ca.category_id=:category_id", Category.class);

        // return results
        return theQuery.getSingleResult();
    }
}
