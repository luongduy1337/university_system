package addict2code.university_v10.controller;

import addict2code.university_v10.dto.CreateTeacherDTO;
import addict2code.university_v10.dto.UpdateTeacherDTO;
import addict2code.university_v10.entity.Teacher;
import addict2code.university_v10.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TeacherRestController {
    private TeacherService teacherService;
    public TeacherRestController(TeacherService theTeacherService){
        this.teacherService = theTeacherService;
    }
    @GetMapping("/teacher")
    List<Teacher> findAll(){return teacherService.findAll();}

    @GetMapping("/teacher/{teacherId}")
    Teacher findOne(@PathVariable int teacherId){ return teacherService.findOne(teacherId); }

    @PostMapping("/teacher")
    void add(@RequestBody CreateTeacherDTO createTeacherDTO){teacherService.add(createTeacherDTO);}

    @PutMapping("/teacher")
    void update(@RequestBody UpdateTeacherDTO updateTeacherDTO){teacherService.update(updateTeacherDTO);}

    @DeleteMapping("/teacher/{teacherId}")
    void delete(@PathVariable int teacherId){teacherService.delete(teacherId);}

}
