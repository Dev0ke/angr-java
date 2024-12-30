import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution84Tests {
    private final Solution84 solution84 = new Solution84();

    @Test
    public void example1() {
        int[] heights = {2, 1, 5, 6, 2, 3};
        int expected = 10;
        Assertions.assertEquals(expected, solution84.largestRectangleArea(heights));
    }

    @Test
    public void example2() {
        int[] heights = {2, 4};
        int expected = 4;
        Assertions.assertEquals(expected, solution84.largestRectangleArea(heights));
    }
}
