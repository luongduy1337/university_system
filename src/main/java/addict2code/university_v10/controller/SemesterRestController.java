package addict2code.university_v10.controller;

import addict2code.university_v10.dto.CreateSemesterDTO;
import addict2code.university_v10.dto.UpdateSemesterDTO;
import addict2code.university_v10.entity.Semester;
import addict2code.university_v10.service.SemesterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SemesterRestController {
    private SemesterService semesterService;

    public SemesterRestController(SemesterService semesterService) {
        this.semesterService = semesterService;
    }

    @GetMapping("/semester")
    List<Semester> findAll(
            @RequestParam(value = "semesterCode", required = false) String semesterCode
    ){
        if(semesterCode != null){
            return semesterService.findByCodeName(semesterCode);
        }else {
            return semesterService.findAll();
        }
    };


    @GetMapping("/semester/{semesterId}")
    Semester findOne(@PathVariable int semesterId){return semesterService.findOne(semesterId);};

    @PostMapping("/semester")
    void add(@RequestBody CreateSemesterDTO createSemesterDTO){semesterService.add(createSemesterDTO);}

    @PutMapping("/semester")
    void update(@RequestBody UpdateSemesterDTO updateSemesterDTO){semesterService.update(updateSemesterDTO);}

    @DeleteMapping("/semester/{semesterId}")
    void delete(@PathVariable int semesterId){semesterService.delete(semesterId);};



}
