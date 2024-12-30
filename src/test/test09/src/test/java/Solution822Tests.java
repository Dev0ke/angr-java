import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution822Tests {
    private final Solution822 solution822 = new Solution822();

    @Test
    public void example1() {
        int[] fronts = {1, 2, 4, 4, 7};
        int[] backs = {1, 3, 4, 1, 3};
        int expected = 2;
        Assertions.assertEquals(expected, solution822.flipgame(fronts, backs));
    }

    @Test
    public void example2() {
        int[] fronts = {1};
        int[] backs = {1};
        int expected = 0;
        Assertions.assertEquals(expected, solution822.flipgame(fronts, backs));
    }
}