package addict2code.university_v10.dao;

import addict2code.university_v10.dto.CreateDepartmentDTO;
import addict2code.university_v10.dto.UpdateDepartmentDTO;
import addict2code.university_v10.entity.Department;

import java.util.List;

public interface DepartmentDAO {
    List<Department> findAll();

    Department findOne(int departmentId);

    void add(CreateDepartmentDTO createDepartmentDTO);

    void update(UpdateDepartmentDTO updateDepartmentDTO);

    void delete(int departmentId);

}
