package addict2code.university_v10.controller;

import addict2code.university_v10.entity.SubjectEnrollment;
import addict2code.university_v10.service.SubjectEnrollmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SubjectEnrollmentRestController {
    private SubjectEnrollmentService subjectEnrollmentService;
    public SubjectEnrollmentRestController(SubjectEnrollmentService theSubjectEnrollmentService){
        this.subjectEnrollmentService = theSubjectEnrollmentService;
    }

    @GetMapping("/subject-enrollment")
    List<SubjectEnrollment> findAll(){
        return subjectEnrollmentService.findAll();
    }

}
