package addict2code.university_v10.controller;

import addict2code.university_v10.dto.CreateStudentDTO;
import addict2code.university_v10.dto.UpdateStudentDTO;
import addict2code.university_v10.entity.Student;
import addict2code.university_v10.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private StudentService studentService;

    public StudentRestController(StudentService theStudentService){
        this.studentService = theStudentService;
    }

    @GetMapping("/student")
    List<Student> findAll(@RequestParam(value = "firstName", required = false) String firstName){
        // phân luồng cho api : nếu có query -> chức năng search , nếu không có query -> chức năng lấy danh sách
        if(firstName != null){
            return studentService.findByFirstName(firstName);
        }else {
            return studentService.findAll();
        }

    }
    @GetMapping("/student/{studentId}")
    Student findOne(@PathVariable int studentId){
        return studentService.findOne(studentId);
    }
    @PostMapping("/student")
    void add(@RequestBody CreateStudentDTO createStudentDTO){studentService.add(createStudentDTO);}

    @DeleteMapping("/student/{studentId}")
    void delete(@PathVariable int studentId){studentService.delete(studentId);}

    @PutMapping("/student")
    void update(@RequestBody UpdateStudentDTO updateStudentDTO){studentService.update(updateStudentDTO);}

    @GetMapping("/student-subjects/{subjectId}")
    List<Student> findAllWithSubjects(@PathVariable int subjectId){return studentService.findAllWithSubjects(subjectId);}
}
