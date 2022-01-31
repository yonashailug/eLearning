package edu.hahu.enrollement.controller;

import edu.hahu.enrollement.model.Enrollment;
import edu.hahu.enrollement.security.UserMoreDetails;
import edu.hahu.enrollement.service.IEnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping
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
    public Enrollment save(@RequestBody @Valid Enrollment enrollment){
        return enrollmentService.save(enrollment);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody @Valid Enrollment enrollment){
        enrollmentService.update(enrollment);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        enrollmentService.deleteById(id);
    }

    @GetMapping("{id}/courses")
    public List<Object> getCourses(@PathVariable Long id) {
        UserMoreDetails user = (UserMoreDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("user id from principal: " + user.getId());
        return enrollmentService.getCoursesByUser(id);
    }
}
