package task_01_test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 1. Создать аннотацию, которая принимает параметры для метода...
 */
@Target(ElementType.METHOD) // Аннотация применяется к методу
@Retention(RetentionPolicy.RUNTIME) // Аннотация применяется во время выполнения программы
public @interface TestAnnotation { // имя аннотации TestAnnotation
    int a(); // параметр аннотации
    int b(); // параметр аннотации
}
