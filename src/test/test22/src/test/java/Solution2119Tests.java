import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2119Tests {
    private final Solution2119 solution2119 = new Solution2119();

    @Test
    public void example1() {
        int num = 526;
        Assertions.assertTrue(solution2119.isSameAfterReversals(num));
    }

    @Test
    public void example2() {
        int num = 1800;
        Assertions.assertFalse(solution2119.isSameAfterReversals(num));
    }

    @Test
    public void example3() {
        int num = 0;
        Assertions.assertTrue(solution2119.isSameAfterReversals(num));
    }
}
