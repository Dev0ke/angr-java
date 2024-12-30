import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1465Tests {
    private final Solution1465 solution1465 = new Solution1465();

    @Test
    public void example1() {
        int h = 5;
        int w = 4;
        int[] horizontalCuts = {1, 2, 4};
        int[] verticalCuts = {1, 3};
        int expected = 4;
        Assertions.assertEquals(expected, solution1465.maxArea(h, w, horizontalCuts, verticalCuts));
    }

    @Test
    public void example2() {
        int h = 5;
        int w = 4;
        int[] horizontalCuts = {3, 1};
        int[] verticalCuts = {1};
        int expected = 6;
        Assertions.assertEquals(expected, solution1465.maxArea(h, w, horizontalCuts, verticalCuts));
    }

    @Test
    public void example3() {
        int h = 5;
        int w = 4;
        int[] horizontalCuts = {3};
        int[] verticalCuts = {3};
        int expected = 9;
        Assertions.assertEquals(expected, solution1465.maxArea(h, w, horizontalCuts, verticalCuts));
    }
}