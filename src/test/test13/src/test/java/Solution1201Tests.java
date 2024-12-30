import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1201Tests {
    private final Solution1201 solution1201 = new Solution1201();

    @Test
    public void example1() {
        int n = 3;
        int a = 2;
        int b = 3;
        int c = 5;
        int expected = 4;
        Assertions.assertEquals(expected, solution1201.nthUglyNumber(n, a, b, c));
    }

    @Test
    public void example2() {
        int n = 4;
        int a = 2;
        int b = 3;
        int c = 4;
        int expected = 6;
        Assertions.assertEquals(expected, solution1201.nthUglyNumber(n, a, b, c));
    }

    @Test
    public void example3() {
        int n = 5;
        int a = 2;
        int b = 11;
        int c = 13;
        int expected = 10;
        Assertions.assertEquals(expected, solution1201.nthUglyNumber(n, a, b, c));
    }

    @Test
    public void example4() {
        int n = 1000000000;
        int a = 2;
        int b = 217983653;
        int c = 336916467;
        int expected = 1999999984;
        Assertions.assertEquals(expected, solution1201.nthUglyNumber(n, a, b, c));
    }
}
