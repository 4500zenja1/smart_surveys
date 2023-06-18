package epolsoft.practice.smart_surveys.exceptions;

public class InvalidDatesException extends RuntimeException {
    public InvalidDatesException(String errorMessage) {
        super(errorMessage);
    }
}
