package addict2code.university_v10.service;

import addict2code.university_v10.dao.SubjectsDAO;
import addict2code.university_v10.entity.Subjects;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectsServiceImpl implements SubjectsService {
    private SubjectsDAO subjectsDAO;

    public SubjectsServiceImpl(SubjectsDAO theSubjectsDAO){
        this.subjectsDAO = theSubjectsDAO;
    }

    @Override
    public List<Subjects> findAll() {
        return subjectsDAO.findAll();
    }
}
