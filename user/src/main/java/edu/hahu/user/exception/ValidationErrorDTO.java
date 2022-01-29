package edu.hahu.user.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorDTO {
    private String errorType;
    private List<FieldErrorDTO> fieldErrors = new ArrayList<>();

    public ValidationErrorDTO(String errorType) {
        this.errorType = errorType;
    }

    public void addFieldError(String path, String message) {
        FieldErrorDTO error = new FieldErrorDTO(path, message);
        fieldErrors.add(error);
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public List<FieldErrorDTO> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(List<FieldErrorDTO> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }
}
