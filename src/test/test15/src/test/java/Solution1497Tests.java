import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1497Tests {
    private final Solution1497 solution1497 = new Solution1497();

    @Test
    public void example1() {
        int[] arr = {1, 2, 3, 4, 5, 10, 6, 7, 8, 9};
        int k = 5;
        Assertions.assertTrue(solution1497.canArrange(arr, k));
    }

    @Test
    public void example2() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int k = 7;
        Assertions.assertTrue(solution1497.canArrange(arr, k));
    }

    @Test
    public void example3() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int k = 10;
        Assertions.assertFalse(solution1497.canArrange(arr, k));
    }
}