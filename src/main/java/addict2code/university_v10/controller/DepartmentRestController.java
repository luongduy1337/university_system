package addict2code.university_v10.controller;

import addict2code.university_v10.dto.CreateDepartmentDTO;
import addict2code.university_v10.dto.UpdateDepartmentDTO;
import addict2code.university_v10.entity.Department;
import addict2code.university_v10.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentRestController {
    private DepartmentService departmentService;

    public DepartmentRestController(DepartmentService theDepartmentService){
        this.departmentService = theDepartmentService;
    }

    @GetMapping("/department")
    List<Department> findAll(){
        return departmentService.findAll();
    }

    @GetMapping("/department/{departmentId}")
    Department findOne(@PathVariable int departmentId){
        return departmentService.findOne(departmentId);
    }

    @PostMapping("/department")
    void add(@RequestBody CreateDepartmentDTO createDepartmentDTO){departmentService.add(createDepartmentDTO);}

    @PutMapping("/department")
    void update(@RequestBody UpdateDepartmentDTO updateDepartmentDTO){departmentService.update(updateDepartmentDTO);}

    @DeleteMapping("/department/{departmentId}")
    void delete(@PathVariable int departmentId){departmentService.delete(departmentId);}
}
