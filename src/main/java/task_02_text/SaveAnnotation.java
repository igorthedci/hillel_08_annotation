package task_02_text;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // Аннотация применяется к классу
@Retention(RetentionPolicy.RUNTIME) // Аннотация применяется во время выполнения программы
public @interface SaveAnnotation { // declare a new annotation
    String backupFile() default  "";
    String backupMethod() default "";
}
