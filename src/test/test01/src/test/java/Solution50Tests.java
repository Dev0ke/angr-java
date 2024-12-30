import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution50Tests {
    private final Solution50 solution50 = new Solution50();

    @Test
    public void example1() {
        double x = 2.00000;
        int n = 10;
        double expected = 1024.00000;
        Assertions.assertEquals(expected, solution50.myPow(x, n), 1e-6);
    }

    @Test
    public void example2() {
        double x = 2.10000;
        int n = 3;
        double expected = 9.26100;
        Assertions.assertEquals(expected, solution50.myPow(x, n), 1e-6);
    }

    @Test
    public void example3() {
        double x = 2.00000;
        int n = -2;
        double expected = 0.25000;
        Assertions.assertEquals(expected, solution50.myPow(x, n), 1e-6);
    }

    // 补充用例
    @Test
    public void example4() {
        double x = 2.00000;
        int n = -2147483648;
        double expected = 0.0;
        Assertions.assertEquals(expected, solution50.myPow(x, n), 1e-6);
    }
}

