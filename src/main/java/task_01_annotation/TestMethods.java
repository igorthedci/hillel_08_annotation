package task_01_annotation;

public class TestMethods {

    public void testMethod1() {
        return;
    }

    public int testMethodSum(int a, int b) {
        return a + b;
    }

    public double testMethodSum(double a, double b) {
        return a + b;
    }

    @TestAnnotation(a = 2, b = 5)
    public int testMethodRandom(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        int rnd = min + (int) (Math.random() * (max - min + 1));

        return rnd;
    }

}
