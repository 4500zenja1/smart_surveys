package epolsoft.practice.smart_surveys.exceptions;

public class InvalidPollException extends RuntimeException {
    public InvalidPollException(String errorMessage) {
        super(errorMessage);
    }
}
