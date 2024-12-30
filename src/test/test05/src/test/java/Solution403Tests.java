import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution403Tests {
    private final Solution403 solution403 = new Solution403();

    @Test
    public void example1() {
        int[] stones = {0, 1, 3, 5, 6, 8, 12, 17};
        Assertions.assertTrue(solution403.canCross(stones));
    }

    @Test
    public void example2() {
        int[] stones = {0, 1, 2, 3, 4, 8, 9, 11};
        Assertions.assertFalse(solution403.canCross(stones));
    }
}