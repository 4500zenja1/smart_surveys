package epolsoft.practice.smart_surveys.exceptions;

public class InvalidUserException extends RuntimeException {
    public InvalidUserException(String errorMessage) {
        super(errorMessage);
    }
}
