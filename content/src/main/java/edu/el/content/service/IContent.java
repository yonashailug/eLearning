package edu.el.content.service;

import edu.el.content.model.Content;

import java.util.List;

public interface IContent {
    List<Content> getAll();

    void add(Content content);

    Content get(long id);

    void update(Content content);

    void delete(long id);

}
