/**
 * 1. Создать аннотацию, которая принимает параметры для метода
 *      TestAnnotation
 *
 * Написать код, который вызовет метод, помеченный этой аннотацией,
 * и передаст параметры аннотации в вызываемый метод.
 * "@TestAnnotation(a=2, b=5)
 * public void test(int a, int b) {...}"
 */
package task_01_annotation;

import java.lang.reflect.Method;


public class Main {

    public static void main(String[] args) throws Exception {
        try {

            TestMethods testM = new TestMethods(); // экземпляр объекта TestMethods
            Class clsM = testM.getClass(); // нашли класс у объекта testMethods
            Method[] mds = clsM.getMethods(); // нашли все методы объекта testMethods

//            TestAnnotation testA = new TestAnnotation(); у абстрактного класса нет экземпляров

            for (Method md : mds) {
                if (md.isAnnotationPresent(TestAnnotation.class)) {
                    TestAnnotation testA = md.getAnnotation(TestAnnotation.class);
                    System.out.println("SUCCESS: " + md.invoke(testM, testA.a(), testA.b()));
                }
                else
                    System.out.printf("%s method does not have %s annotation.\n",
                            md.getName(), TestAnnotation.class.getName());
            }
        } catch (Exception ex) {
            System.out.println("catch section:: " + ex.toString());
        }
    }


}

