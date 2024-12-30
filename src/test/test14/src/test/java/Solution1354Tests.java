import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1354Tests {
    private final Solution1354 solution1354 = new Solution1354();

    @Test
    public void example1() {
        int[] target = {9, 3, 5};
        Assertions.assertTrue(solution1354.isPossible(target));
    }

    @Test
    public void example2() {
        int[] target = {1, 1, 1, 2};
        Assertions.assertFalse(solution1354.isPossible(target));
    }

    @Test
    public void example3() {
        int[] target = {8, 5};
        Assertions.assertTrue(solution1354.isPossible(target));
    }
}