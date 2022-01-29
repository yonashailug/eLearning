package edu.hahu.enrollement.controller;

import edu.hahu.enrollement.model.Enrollment;
import edu.hahu.enrollement.service.IEnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/enrollments")
public class EnrollmentController {

    @Autowired
    private IEnrollmentService enrollmentService;

    @GetMapping
    public List<Enrollment> getAll(){
        return enrollmentService.findAll();
    }

    @GetMapping("/{id}")
    public Enrollment getById(@PathVariable Long id){
        return enrollmentService.findById(id);
    }

    @PostMapping
    public Enrollment save(@RequestBody Enrollment enrollment){
        return enrollmentService.save(enrollment);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Enrollment enrollment){
        enrollmentService.update(enrollment);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        enrollmentService.deleteById(id);
    }

}
