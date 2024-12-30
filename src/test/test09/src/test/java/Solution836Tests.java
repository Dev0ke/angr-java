import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution836Tests {
    private final Solution836 solution836 = new Solution836();

    @Test
    public void example1() {
        int[] rec1 = {0, 0, 2, 2};
        int[] rec2 = {1, 1, 3, 3};
        Assertions.assertTrue(solution836.isRectangleOverlap(rec1, rec2));
    }

    @Test
    public void example2() {
        int[] rec1 = {0, 0, 1, 1};
        int[] rec2 = {1, 0, 2, 1};
        Assertions.assertFalse(solution836.isRectangleOverlap(rec1, rec2));
    }

    @Test
    public void example3() {
        int[] rec1 = {0, 0, 1, 1};
        int[] rec2 = {2, 2, 3, 3};
        Assertions.assertFalse(solution836.isRectangleOverlap(rec1, rec2));
    }
}
