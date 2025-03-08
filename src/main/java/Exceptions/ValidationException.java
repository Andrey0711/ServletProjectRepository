package Exceptions;

import java.util.List;

public class ValidationException extends RuntimeException{
    private final List<Error> errorList;

    public ValidationException(List<Error> errorList) {
        this.errorList = errorList;
    }
}
