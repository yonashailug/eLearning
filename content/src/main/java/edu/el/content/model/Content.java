package edu.el.content.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Content {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String content;
    private String chapter;
    private String contentType;
    private Status status;

    public Content(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}