package addict2code.university_v10.controller;

import addict2code.university_v10.dto.CreateStudentDTO;
import addict2code.university_v10.dto.CreateUniversityDTO;
import addict2code.university_v10.dto.UpdateUniversityDTO;
import addict2code.university_v10.entity.University;
import addict2code.university_v10.service.UniversityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UniversityRestController {
    private UniversityService universityService;

    // initialize constructor
    public UniversityRestController(UniversityService theUniversityService){
        this.universityService = theUniversityService;
    }
    @GetMapping("/university")
    List<University> findAll(){
        return universityService.findAll();
    }

    @GetMapping("/university/{universityId}")
    University findOne(@PathVariable int universityId){return universityService.findOne(universityId);}

    @PostMapping("/university")
    void add(@RequestBody CreateUniversityDTO createUniversityDTO){universityService.add(createUniversityDTO);}

    @PutMapping("/university")
    void update(@RequestBody UpdateUniversityDTO updateUniversityDTO){universityService.update(updateUniversityDTO);}

    @DeleteMapping("/university/{universityId}")
    void delete(@PathVariable int universityId){universityService.delete(universityId);}

}
