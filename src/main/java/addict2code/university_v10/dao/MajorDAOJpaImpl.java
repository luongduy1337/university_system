package addict2code.university_v10.dao;

import addict2code.university_v10.dto.CreateMajorDTO;
import addict2code.university_v10.dto.UpdateMajorDTO;
import addict2code.university_v10.entity.Department;
import addict2code.university_v10.entity.Major;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MajorDAOJpaImpl implements MajorDAO {
    private EntityManager entityManager;
    private DepartmentDAO departmentDAO;

    public MajorDAOJpaImpl(EntityManager theEntityManager){
        this.entityManager = theEntityManager;
    }
    @Override
    public List<Major> findAll() {
        // create query
        TypedQuery<Major> query = entityManager.createQuery("SELECT ma FROM Major ma", Major.class);
        // return results
        return query.getResultList();
    }

    @Override
    public Major findOne(int majorId) {
        // create query
        TypedQuery<Major> query = entityManager.createQuery("SELECT ma FROM Major ma WHERE ma.majorId=:majorId", Major.class);

        query.setParameter("majorId", majorId);
        // return results
        return query.getSingleResult();
    }

    @Transactional
    @Override
    public void add(CreateMajorDTO createMajorDTO) {
        int departmentId = createMajorDTO.getDepartmentId();
        Department departmentAdd = this.departmentDAO.findOne(departmentId);
        Major newMajor = new Major();
        newMajor.setMajorName(createMajorDTO.getMajorName());
        newMajor.setDepartment(departmentAdd);
        entityManager.persist(newMajor);
    }



    @Transactional
    @Override
    public void update(UpdateMajorDTO updateMajorDTO) {
        int majorId = updateMajorDTO.getMajorId();
        Major majorUpdated = this.findOne(majorId);
        majorUpdated.setMajorName(updateMajorDTO.getMajorName());
        entityManager.persist(majorUpdated);
    }

    @Transactional
    @Override
    public void delete(int majorId) {
        Major majorDeleted = this.findOne(majorId);
        majorDeleted.setIsDelete(1);
    }
}
