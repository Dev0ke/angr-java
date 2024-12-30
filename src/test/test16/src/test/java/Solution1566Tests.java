import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1566Tests {
    private final Solution1566 solution1566 = new Solution1566();

    @Test
    public void example1() {
        int[] arr = {1, 2, 4, 4, 4, 4};
        int m = 1;
        int k = 3;
        Assertions.assertTrue(solution1566.containsPattern(arr, m, k));
    }

    @Test
    public void example2() {
        int[] arr = {1, 2, 1, 2, 1, 1, 1, 3};
        int m = 2;
        int k = 2;
        Assertions.assertTrue(solution1566.containsPattern(arr, m, k));
    }

    @Test
    public void example3() {
        int[] arr = {1, 2, 1, 2, 1, 3};
        int m = 2;
        int k = 3;
        Assertions.assertFalse(solution1566.containsPattern(arr, m, k));
    }

    @Test
    public void example4() {
        int[] arr = {1, 2, 3, 1, 2};
        int m = 2;
        int k = 2;
        Assertions.assertFalse(solution1566.containsPattern(arr, m, k));
    }

    @Test
    public void example5() {
        int[] arr = {2, 2, 2, 2};
        int m = 2;
        int k = 3;
        Assertions.assertFalse(solution1566.containsPattern(arr, m, k));
    }
}