import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1420Tests {
    private final Solution1420 solution1420 = new Solution1420();

    @Test
    public void example1() {
        int n = 2;
        int m = 3;
        int k = 1;
        int expected = 6;
        Assertions.assertEquals(expected, solution1420.numOfArrays(n, m, k));
    }

    @Test
    public void example2() {
        int n = 5;
        int m = 2;
        int k = 3;
        int expected = 0;
        Assertions.assertEquals(expected, solution1420.numOfArrays(n, m, k));
    }

    @Test
    public void example3() {
        int n = 9;
        int m = 1;
        int k = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solution1420.numOfArrays(n, m, k));
    }

    @Test
    public void example4() {
        int n = 50;
        int m = 100;
        int k = 25;
        int expected = 34549172;
        Assertions.assertEquals(expected, solution1420.numOfArrays(n, m, k));
    }

    @Test
    public void example5() {
        int n = 37;
        int m = 17;
        int k = 7;
        int expected = 418930126;
        Assertions.assertEquals(expected, solution1420.numOfArrays(n, m, k));
    }
}
