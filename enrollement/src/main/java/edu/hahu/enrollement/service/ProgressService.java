package edu.hahu.enrollement.service;

import edu.hahu.enrollement.dao.ProgressDao;
import edu.hahu.enrollement.model.Progress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgressService implements IProgressService {

    @Autowired
    private ProgressDao progressDao;

    @Override
    public List<Progress> findAll() {
        return progressDao.findAll();
    }

    @Override
    public Progress findById(Long id) {
        return progressDao.getById(id);
    }

    @Override
    public Progress save(Progress progress) {
        return progressDao.save(progress);
    }

    @Override
    public void update(Progress progress) {
        progressDao.save(progress);
    }

    @Override
    public void deleteById(Long id) {
        progressDao.deleteById(id);
    }
}
