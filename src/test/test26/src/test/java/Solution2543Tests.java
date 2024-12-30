import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2543Tests {
    private final Solution2543 solution2543 = new Solution2543();

    @Test
    public void example1() {
        int targetX = 6;
        int targetY = 9;
        Assertions.assertFalse(solution2543.isReachable(targetX, targetY));
    }

    @Test
    public void example2() {
        int targetX = 4;
        int targetY = 7;
        Assertions.assertTrue(solution2543.isReachable(targetX, targetY));
    }
}