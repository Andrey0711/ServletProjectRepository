package Mapper;

public interface Mapper<F, T> {
    T mapFrom(F obj);
}
