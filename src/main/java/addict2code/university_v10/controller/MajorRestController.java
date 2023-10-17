package addict2code.university_v10.controller;

import addict2code.university_v10.dto.CreateMajorDTO;
import addict2code.university_v10.dto.UpdateMajorDTO;
import addict2code.university_v10.entity.Major;
import addict2code.university_v10.service.MajorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MajorRestController {
    private MajorService majorService;

    public MajorRestController(MajorService theMajorService){
        this.majorService = theMajorService;
    }

    @GetMapping("/major")
    List<Major> findAll(){return majorService.findAll();}

    @GetMapping("/major/{majorId}")
    Major findOne(@PathVariable int majorId){return majorService.findOne(majorId);}

    @PostMapping("/major")
    void add(@RequestBody CreateMajorDTO createMajorDTO){majorService.add(createMajorDTO);}

    @PutMapping("/major")
    void update(@RequestBody UpdateMajorDTO updateMajorDTO){majorService.update(updateMajorDTO);}

    @DeleteMapping("/major/{majorId}")
    void delete(@PathVariable int majorId){majorService.delete(majorId);}


}
