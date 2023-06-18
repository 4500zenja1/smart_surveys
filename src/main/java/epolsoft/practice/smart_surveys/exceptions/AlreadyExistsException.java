package epolsoft.practice.smart_surveys.exceptions;

public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException(String errorMessage) {
        super(errorMessage);
    }
}
