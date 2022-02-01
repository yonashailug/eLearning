package edu.el.content.service;

import edu.el.content.dao.ContentDao;
import edu.el.content.model.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ContentService implements IContent {

    @Autowired
    private ContentDao contentDao;

    @Override
    public List<Content> getAll() {
        return contentDao.findAll();
    }

    @Override
    public void add(Content content) {
        contentDao.save(content);
    }

    @Override
    public Content get(long id) {
        return contentDao.getById(id);
    }

    @Override
    public void update(Content content) {
        contentDao.save(content);
    }

    @Override
    public void delete(long id) {
        contentDao.deleteById(id);
    }

}
