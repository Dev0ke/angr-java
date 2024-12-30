import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1306Tests {
    private final Solution1306 solution1306 = new Solution1306();

    @Test
    public void example1() {
        int[] arr = {4, 2, 3, 0, 3, 1, 2};
        int start = 5;
        Assertions.assertTrue(solution1306.canReach(arr, start));
    }

    @Test
    public void example2() {
        int[] arr = {4, 2, 3, 0, 3, 1, 2};
        int start = 0;
        Assertions.assertTrue(solution1306.canReach(arr, start));
    }

    @Test
    public void example3() {
        int[] arr = {3, 0, 2, 1, 2};
        int start = 2;
        Assertions.assertFalse(solution1306.canReach(arr, start));
    }
}
