/**
 * 1. Создать аннотацию, которая принимает параметры для метода.
 * Написать код, который вызовет метод, помеченный этой аннотацией,
 * и передаст параметры аннотации в вызываемый метод.
 * "@Test(a=2, b=5)
 * public void test(int a, int b) {...}"
 */
package task_01_test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        try {
            Class clsAnn = Annotations.class;
            Class clsTest = Annotations.Test.class;
            Method[] mtds = clsAnn.getMethods();
            for (Method mtd : mtds) {
                if (mtd.isAnnotationPresent(clsTest)) {
                    Annotations.Test ann = (Annotations.Test) mtd.getAnnotation(clsTest);
                    mtd.invoke(clsAnn.newInstance(), ann.a(), ann.b());
                }
                else
                    System.out.printf("%s method does not have %s annotation.\n", mtd.getName(), clsTest.getName());
            }
        } catch (Exception ex) {
            System.out.println("catch section:: " + ex.toString());
        }
    }


}

