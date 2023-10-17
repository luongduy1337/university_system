package addict2code.university_v10.controller;

import addict2code.university_v10.entity.Subjects;
import addict2code.university_v10.service.SubjectsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SubjectsRestController {
    private SubjectsService subjectsService;

    // initialize constructor
    public SubjectsRestController(SubjectsService theSubjectsService){
        this.subjectsService = theSubjectsService;
    }

    @GetMapping("/subjects")
    List<Subjects> findAll(){
        return subjectsService.findAll();
    }
}
