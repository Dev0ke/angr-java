import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution946Tests {
    private final Solution946 solution946 = new Solution946();

    @Test
    public void example1() {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};
        Assertions.assertTrue(solution946.validateStackSequences(pushed, popped));
    }

    @Test
    public void example2() {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 3, 5, 1, 2};
        Assertions.assertFalse(solution946.validateStackSequences(pushed, popped));
    }
}
