package addict2code.university_v10.dao;

import addict2code.university_v10.dto.CreateDepartmentDTO;
import addict2code.university_v10.dto.UpdateDepartmentDTO;
import addict2code.university_v10.entity.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class DepartmentDAOJpaImpl implements DepartmentDAO {
    private EntityManager entityManager;
    public DepartmentDAOJpaImpl(EntityManager theEntityManager){
        this.entityManager = theEntityManager;
    }
    @Override
    public List<Department> findAll() {
        // create query
        TypedQuery<Department> query = entityManager.createQuery("SELECT de FROM Department de", Department.class);
        return query.getResultList();
    }

    @Override
    public Department findOne(int departmentId) {
        // create query
        TypedQuery<Department> query = entityManager.createQuery("SELECT de FROM Department de WHERE de.departmentId=:departmentId", Department.class);

        // pass parameters
        query.setParameter("departmentId",  departmentId);

        // return result
        return query.getSingleResult();
    }


    @Transactional
    @Override
    public void add(CreateDepartmentDTO createDepartmentDTO) {
        Department newDepartment = new Department();
        newDepartment.setDepartmentName(createDepartmentDTO.getDepartmentName());
        newDepartment.setIsDelete(0);
        entityManager.persist(newDepartment);
    }

    @Transactional
    @Override
    public void update(UpdateDepartmentDTO updateDepartmentDTO) {
        int departmentId = updateDepartmentDTO.getDepartmentId();
        Department departmentUpdated = this.findOne(departmentId);
        departmentUpdated.setDepartmentName(updateDepartmentDTO.getDepartmentName());
        entityManager.persist(departmentUpdated);
    }

    @Transactional
    @Override
    public void delete(int departmentId) {
        Department departmentDeleted = this.findOne(departmentId);
        departmentDeleted.setIsDelete(1);
    }
}
