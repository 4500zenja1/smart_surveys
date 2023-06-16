package epolsoft.practice.smart_surveys.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String errorMessage){
        super(errorMessage);
    }
}
