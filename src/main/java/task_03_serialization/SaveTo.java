package task_03_serialization;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Inherited
@Retention(value = RetentionPolicy.RUNTIME)
public @interface SaveTo {
    String PATH(); // = ""/home/roman/ROMA/JAVA/ProgKievUa/HW1 Refl 13.10/Task2/file.txt"";
}