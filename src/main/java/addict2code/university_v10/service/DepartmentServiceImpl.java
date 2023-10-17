package addict2code.university_v10.service;

import addict2code.university_v10.dao.DepartmentDAO;
import addict2code.university_v10.dto.CreateDepartmentDTO;
import addict2code.university_v10.dto.UpdateDepartmentDTO;
import addict2code.university_v10.entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentDAO departmentDAO;

    public DepartmentServiceImpl(DepartmentDAO theDepartmentDAO){
        this.departmentDAO = theDepartmentDAO;
    }
    @Override
    public List<Department> findAll() {
        return departmentDAO.findAll();
    }

    @Override
    public Department findOne(int departmentId) {
        return departmentDAO.findOne(departmentId);
    }

    @Override
    public void add(CreateDepartmentDTO createDepartmentDTO) {
        departmentDAO.add(createDepartmentDTO);
    }

    @Override
    public void update(UpdateDepartmentDTO updateDepartmentDTO) {
        departmentDAO.update(updateDepartmentDTO);
    }

    @Override
    public void delete(int departmentId) {
        departmentDAO.delete(departmentId);
    }
}
