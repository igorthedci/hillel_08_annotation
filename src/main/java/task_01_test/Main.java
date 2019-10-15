/**
 * 1. Создать аннотацию, которая принимает параметры для метода.
 * Написать код, который вызовет метод, помеченный этой аннотацией,
 * и передаст параметры аннотации в вызываемый метод.
 * "@Test(a=2, b=5)
 * public void test(int a, int b) {...}"
 */
package task_01_test;

import java.lang.reflect.Method;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        try {
            Class clsAnn = Annotations.class;
//            Class[] paramClass = new Class[]{int.class, int.class};
            List<Object> arguments = new ArrayList<>();
            Method[] mtds = cls.getMethods();
            for (Method mtd : mtds) {
                Annotations.Test ann = mtd.getAnnotation(Test.class);
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

