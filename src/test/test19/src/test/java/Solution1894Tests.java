import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1894Tests {
    private final Solution1894 solution1894 = new Solution1894();

    @Test
    public void example1() {
        int[] chalk = {5, 1, 5};
        int k = 22;
        int expected = 0;
        Assertions.assertEquals(expected, solution1894.chalkReplacer(chalk, k));
    }

    @Test
    public void example2() {
        int[] chalk = {3, 4, 1, 2};
        int k = 25;
        int expected = 1;
        Assertions.assertEquals(expected, solution1894.chalkReplacer(chalk, k));
    }
}
