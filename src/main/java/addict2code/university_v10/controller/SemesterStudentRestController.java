package addict2code.university_v10.controller;

import addict2code.university_v10.dao.StudentDAO;
import addict2code.university_v10.dto.CreateSemesterStudentDTO;
import addict2code.university_v10.dto.UpdateSemesterStudentDTO;
import addict2code.university_v10.entity.SemesterStudent;
import addict2code.university_v10.service.SemesterStudentService;
import addict2code.university_v10.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SemesterStudentRestController {
    private SemesterStudentService semesterStudentService;

    private StudentService studentService;

    public SemesterStudentRestController(SemesterStudentService semesterStudentService) {
        this.semesterStudentService = semesterStudentService;
    }

    @GetMapping("/semester-students")
    List<SemesterStudent> findAll(){return semesterStudentService.findAll();}

    @GetMapping("/semester-student/studentId/{studentId}")
    List<SemesterStudent> findByStudentId(@PathVariable int studentId){return semesterStudentService.findByStudent(studentId);}

    @GetMapping("/semester-student/semesterId/{semesterId}")
    List<SemesterStudent> findBySemesterId(@PathVariable int semesterId){return semesterStudentService.findBySemester(semesterId);}

    @GetMapping("/semester-student")
    SemesterStudent findOne(@RequestParam("semesterId") int semesterId, @RequestParam("studentId") int studentId){return semesterStudentService.findOne(semesterId, studentId);}

    @PostMapping("/semester-student")
    void add(@RequestBody CreateSemesterStudentDTO createSemesterStudentDTO){semesterStudentService.add(createSemesterStudentDTO);}

    @PutMapping("/semester-student")
    void update(@RequestBody UpdateSemesterStudentDTO updateSemesterStudentDTO, @RequestParam("semesterId") int semesterId, @RequestParam("studentId") int studentId){
        semesterStudentService.update(updateSemesterStudentDTO, semesterId, studentId);
    }

    @DeleteMapping("/semester-student")
    void delete(@RequestParam("semesterId") int semesterId, @RequestParam("studentId") int studentId){semesterStudentService.delete(semesterId, studentId);}

}
