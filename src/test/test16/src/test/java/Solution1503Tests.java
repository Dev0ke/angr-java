import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1503Tests {
    private final Solution1503 solution1503 = new Solution1503();

    @Test
    public void example1() {
        int n = 4;
        int[] left = {4, 3};
        int[] right = {0, 1};
        int expected = 4;
        Assertions.assertEquals(expected, solution1503.getLastMoment(n, left, right));
    }

    @Test
    public void example2() {
        int n = 7;
        int[] left = {};
        int[] right = {0, 1, 2, 3, 4, 5, 6, 7};
        int expected = 7;
        Assertions.assertEquals(expected, solution1503.getLastMoment(n, left, right));
    }

    @Test
    public void example3() {
        int n = 7;
        int[] left = {0, 1, 2, 3, 4, 5, 6, 7};
        int[] right = {};
        int expected = 7;
        Assertions.assertEquals(expected, solution1503.getLastMoment(n, left, right));
    }
}
