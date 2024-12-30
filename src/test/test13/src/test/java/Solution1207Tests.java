import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1207Tests {
    private final Solution1207 solution1207 = new Solution1207();

    @Test
    public void example1() {
        int[] arr = {1, 2, 2, 1, 1, 3};
        Assertions.assertTrue(solution1207.uniqueOccurrences(arr));
    }

    @Test
    public void example2() {
        int[] arr = {1, 2};
        Assertions.assertFalse(solution1207.uniqueOccurrences(arr));
    }

    @Test
    public void example3() {
        int[] arr = {-3, 0, 1, -3, 1, 1, 1, -3, 10, 0};
        Assertions.assertTrue(solution1207.uniqueOccurrences(arr));
    }
}