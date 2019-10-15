/**
 * 1. Создать аннотацию, которая принимает параметры для метода.
 * Написать код, который вызовет метод, помеченный этой аннотацией,
 * и передаст параметры аннотации в вызываемый метод.
 * "@Test(a=2, b=5)
 * public void test(int a, int b) {...}"
 */
package task_01_test;

import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.List;

public class Main {

    @Target(ElementType.METHOD) // Аннотация применяется к методу
    @Retention(RetentionPolicy.RUNTIME) // Аннотация применяется во время выполнения программы
    public @interface Test { // имя аннотации Test
        int a(); // параметр аннотации

        int b(); // параметр аннотации
    }

    public static void main(String[] args) throws Exception {
        try {
            Class cls = Main.class;
            Class[] paramClass = new Class[]{int.class, int.class};
            List<Object> arguments = new ArrayList<>();
            Method[] mtds = Test.class.getMethods();
            for (Method mtd : mtds) {
                Test ann = mtd.getAnnotation(Test.class);
                arguments.add(mtd.invoke(ann, (Object[]) null));
                mtd.invoke(cls.newInstance(), ann.a(), ann.b());
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    @Test(a = 2, b = 5)
    public void test(int a, int b) {
        System.out.printf("Sum of numbers %d and %d is %d.", a, b, a + b);
    }

}

