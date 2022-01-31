package edu.hahu.enrollement.controller;

import edu.hahu.enrollement.model.Progress;
import edu.hahu.enrollement.service.IProgressService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/progresses")
public class ProgressController {

    private final IProgressService progressService;

    public ProgressController(IProgressService progressService) {
        this.progressService = progressService;
    }

    @GetMapping
    public List<Progress> findAll(){
        return progressService.findAll();
    }

    @GetMapping("/{id}")
    public Progress findById(@PathVariable Long id){
        return progressService.findById(id);
    }

    @PostMapping
    public Progress save(@RequestBody @Valid Progress progress) {
       return progressService.save(progress);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody @Valid Progress progress){
        progressService.update(progress);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        progressService.deleteById(id);
    }
}
