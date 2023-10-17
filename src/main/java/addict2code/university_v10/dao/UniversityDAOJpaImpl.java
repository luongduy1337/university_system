package addict2code.university_v10.dao;

import addict2code.university_v10.dto.CreateStudentDTO;
import addict2code.university_v10.dto.CreateUniversityDTO;
import addict2code.university_v10.dto.UpdateStudentDTO;
import addict2code.university_v10.dto.UpdateUniversityDTO;
import addict2code.university_v10.entity.University;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UniversityDAOJpaImpl implements UniversityDAO {
    private EntityManager entityManager;
    public UniversityDAOJpaImpl(EntityManager theEntityManager){
        this.entityManager = theEntityManager;
    }
    @Override
    public List<University> findAll() {
        // create query
        TypedQuery<University> query = entityManager.createQuery("SELECT uni FROM University uni LEFT JOIN uni.subjects WHERE uni.isDelete = 0", University.class);

        // return results
        return query.getResultList();

    }

    @Override
    public University findOne(int universityId) {
        // create query
        TypedQuery<University> query = entityManager.createQuery("SELECT uni FROM University uni WHERE uni.universityId=:universityId AND uni.isDelete = 0", University.class);
        query.setParameter("universityId", universityId);
        // return result
        return query.getSingleResult();
    }

    @Transactional
    @Override
    public void add(CreateUniversityDTO createUniversityDTO) {
        University newUniversity = new University();
        newUniversity.setUniversityName(createUniversityDTO.getUniversityName());
        newUniversity.setStreetNumber(createUniversityDTO.getStreetNumber());
        newUniversity.setStreetName(createUniversityDTO.getStreetName());
        newUniversity.setUnitNumber(createUniversityDTO.getUnitNumber());
        newUniversity.setSuburb(createUniversityDTO.getSuburb());
        newUniversity.setCity(createUniversityDTO.getCity());
        newUniversity.setState(createUniversityDTO.getState());
        newUniversity.setUniversityCode(createUniversityDTO.getUniversityCode());
        newUniversity.setCountry(createUniversityDTO.getCountry());
        newUniversity.setIsDelete(0);
        entityManager.persist(newUniversity);

    }

    @Override
    @Transactional
    public void update(UpdateUniversityDTO updateUniversityDTO) {
        int universityId = updateUniversityDTO.getUniversityId();
        University universityUpdated = this.findOne(universityId);
        universityUpdated.setUniversityName(updateUniversityDTO.getUniversityName());
        universityUpdated.setStreetNumber(updateUniversityDTO.getStreetNumber());
        universityUpdated.setStreetName(updateUniversityDTO.getStreetName());
        universityUpdated.setUnitNumber(updateUniversityDTO.getUnitNumber());
        universityUpdated.setSuburb(updateUniversityDTO.getSuburb());
        universityUpdated.setCity(updateUniversityDTO.getCity());
        universityUpdated.setState(updateUniversityDTO.getState());
        universityUpdated.setUniversityCode(updateUniversityDTO.getUniversityCode());
        universityUpdated.setCountry(updateUniversityDTO.getCountry());
        entityManager.persist(universityUpdated);

    }

    @Override
    @Transactional
    public void delete(int universityId) {
        University universityDeleted = this.findOne(universityId);
        universityDeleted.setIsDelete(1);
    }
}
