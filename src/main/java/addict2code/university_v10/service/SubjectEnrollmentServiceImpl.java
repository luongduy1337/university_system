package addict2code.university_v10.service;

import addict2code.university_v10.dao.SubjectEnrollmentDAO;
import addict2code.university_v10.dao.SubjectEnrollmentDAOJpaImpl;
import addict2code.university_v10.entity.SubjectEnrollment;
import addict2code.university_v10.entity.Subjects;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SubjectEnrollmentServiceImpl implements SubjectEnrollmentService {
    private SubjectEnrollmentDAO subjectEnrollmentDAO;
    public SubjectEnrollmentServiceImpl(SubjectEnrollmentDAO theSubjectEnrollmentDAO){
        this.subjectEnrollmentDAO = theSubjectEnrollmentDAO;
    }
    @Override
    public List<SubjectEnrollment> findAll() {
        return subjectEnrollmentDAO.findAll();
    }
}
