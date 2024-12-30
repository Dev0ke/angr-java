import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2834Tests {
    private final Solution2834 solution2834 = new Solution2834();

    @Test
    public void example1() {
        int n = 3;
        int target = 3;
        int expected = 8;
        Assertions.assertEquals(expected, solution2834.minimumPossibleSum(n, target));
    }

    @Test
    public void example2() {
        int n = 1;
        int target = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solution2834.minimumPossibleSum(n, target));
    }
}