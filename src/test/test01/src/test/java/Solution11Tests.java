import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution11Tests {
    private final Solution11 solution11 = new Solution11();

    @Test
    public void example1() {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int expected = 49;
        Assertions.assertEquals(expected, solution11.maxArea(height));
    }

    @Test
    public void example2() {
        int[] height = {1, 1};
        int expected = 1;
        Assertions.assertEquals(expected, solution11.maxArea(height));
    }

    @Test
    public void example3() {
        int[] height = {4, 3, 2, 1, 4};
        int expected = 16;
        Assertions.assertEquals(expected, solution11.maxArea(height));
    }

    @Test
    public void example4() {
        int[] height = {1, 2, 1};
        int expected = 2;
        Assertions.assertEquals(expected, solution11.maxArea(height));
    }
}
