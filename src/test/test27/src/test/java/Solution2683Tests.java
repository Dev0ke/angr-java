import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2683Tests {
    private final Solution2683 solution2683 = new Solution2683();

    @Test
    public void example1() {
        int[] derived = {1, 1, 0};
        Assertions.assertTrue(solution2683.doesValidArrayExist(derived));
    }

    @Test
    public void example2() {
        int[] derived = {1, 1};
        Assertions.assertTrue(solution2683.doesValidArrayExist(derived));
    }

    @Test
    public void example3() {
        int[] derived = {1, 0};
        Assertions.assertFalse(solution2683.doesValidArrayExist(derived));
    }
}