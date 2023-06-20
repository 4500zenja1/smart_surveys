package epolsoft.practice.smart_surveys.exceptions;

public class ConflictException extends RuntimeException {
    public ConflictException(Error e) {
        super(e);
    }
}
