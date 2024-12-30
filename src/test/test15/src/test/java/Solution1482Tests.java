import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1482Tests {
    private final Solution1482 solution1482 = new Solution1482();

    @Test
    public void example1() {
        int[] bloomDay = {1, 10, 3, 10, 2};
        int m = 3;
        int k = 1;
        int expected = 3;
        Assertions.assertEquals(expected, solution1482.minDays(bloomDay, m, k));
    }

    @Test
    public void example2() {
        int[] bloomDay = {1, 10, 3, 10, 2};
        int m = 3;
        int k = 2;
        int expected = -1;
        Assertions.assertEquals(expected, solution1482.minDays(bloomDay, m, k));
    }

    @Test
    public void example3() {
        int[] bloomDay = {7, 7, 7, 7, 12, 7, 7};
        int m = 2;
        int k = 3;
        int expected = 12;
        Assertions.assertEquals(expected, solution1482.minDays(bloomDay, m, k));
    }

    @Test
    public void example4() {
        int[] bloomDay = {1000000000, 1000000000};
        int m = 1;
        int k = 1;
        int expected = 1000000000;
        Assertions.assertEquals(expected, solution1482.minDays(bloomDay, m, k));
    }

    @Test
    public void example5() {
        int[] bloomDay = {1, 10, 2, 9, 3, 8, 4, 7, 5, 6};
        int m = 4;
        int k = 2;
        int expected = 9;
        Assertions.assertEquals(expected, solution1482.minDays(bloomDay, m, k));
    }
}
