package edu.hahu.user.exception;

public class FieldErrorDto {
    private String field;
    private String message;

    public FieldErrorDto(String field, String message) {
        this.field = field;
        this.message = message;
    }

    @Override
    public String toString() {
        return "FieldErrorDTO [field=" + field + ", message=" + message + "]";
    }
}
