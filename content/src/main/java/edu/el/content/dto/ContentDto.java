package edu.el.content.dto;

import edu.el.content.model.Status;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class ContentDto {
    private Long id;
    private String name;
    private String content;
    private String chapter;
    private String contentType;
    private Status status;
}
