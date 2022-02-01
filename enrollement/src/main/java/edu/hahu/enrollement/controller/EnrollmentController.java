package edu.hahu.enrollement.controller;

import edu.hahu.enrollement.model.Enrollment;
import edu.hahu.enrollement.model.Progress;
import edu.hahu.enrollement.security.UserMoreDetails;
import edu.hahu.enrollement.service.IEnrollmentService;
import edu.hahu.enrollement.service.IProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class EnrollmentController {

    @Autowired
    private IEnrollmentService enrollmentService;

    @Autowired
    private IProgressService progressService;


    @GetMapping
    public List<Enrollment> getAll() {
        return enrollmentService.findAll();
    }

    @GetMapping("/{id}")
    public Enrollment getById(@PathVariable Long id) {
        return enrollmentService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Enrollment> save(@RequestBody @Valid Enrollment enrollment) {
        UserMoreDetails user = (UserMoreDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        enrollment.setTraineeId(user.getId());
        Optional<Enrollment> result = enrollmentService.save(enrollment);
        if (result.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(result.get());
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody @Valid Enrollment enrollment) {
        enrollmentService.update(enrollment);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        enrollmentService.deleteById(id);
    }

    @GetMapping("{id}/courses")
    public List<Object> getCourses(@PathVariable Long id) {
        UserMoreDetails user = (UserMoreDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("user id from principal: " + user.getId());
        return enrollmentService.getCoursesByUser(id);
    }


    /****** Progresss ***/
    @GetMapping("/{id}/progress")
    public List<Progress> findAll() {
        return progressService.findAll();
    }


    @GetMapping("/{id}/progress/{progressId}")
    public Progress findById(@PathVariable Long progressId) {
        return progressService.findById(progressId);
    }

    @PostMapping("/{id}/progress")
    public Progress save(@RequestBody @Valid Progress progress, @PathVariable Long id) {
        Enrollment enrollment = enrollmentService.findById(id);
        progress.setEnrollment(enrollment);
        return progressService.save(progress);
    }

    @PutMapping("/{id}/progress/{progressId}")
    public void update(@PathVariable Long id, @PathVariable Long progressId, @RequestBody @Valid Progress progress) {
        Enrollment enrollment = enrollmentService.findById(id);
        progress.setEnrollment(enrollment);
        progressService.update(progress);
    }

    @DeleteMapping("/{id}/progress/{progressId}")
    public void deleteProgressById(@PathVariable Long progressId) {
        progressService.deleteById(progressId);
    }

}
