package edu.hahu.user.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorDto {
    private String errorType;
    private List<FieldErrorDto> fieldErrors = new ArrayList<>();

    public ValidationErrorDto(String errorType) {
        this.errorType = errorType;
    }

    public void addFieldError(String path, String message) {
        FieldErrorDto error = new FieldErrorDto(path, message);
        fieldErrors.add(error);
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public List<FieldErrorDto> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(List<FieldErrorDto> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }
}
