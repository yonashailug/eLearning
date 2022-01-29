package edu.el.content.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Setter
@Getter
public class Content {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String name;

    @Lob
    @NotBlank
    private String content;

    @NotBlank
    private String chapter;

    @Enumerated(EnumType.STRING)
    private ContentType contentType;

    @Enumerated(EnumType.STRING)
    private Status status;

}