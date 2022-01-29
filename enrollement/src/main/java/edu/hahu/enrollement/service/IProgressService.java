package edu.hahu.enrollement.service;

import edu.hahu.enrollement.model.Progress;

import java.util.List;

public interface IProgressService {

    public List<Progress> findAll();

    public Progress findById(Long id);

    public Progress save(Progress progress);

    public void update(Progress progress);

    public void deleteById(Long id);

}
