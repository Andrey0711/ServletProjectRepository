package Validators;

public interface Validator<T> {
    ValidationResult isValid(T obj);
}
