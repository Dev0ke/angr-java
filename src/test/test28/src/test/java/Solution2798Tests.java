import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2798Tests {
    private final Solution2798 solution2798 = new Solution2798();

    @Test
    public void example1() {
        int[] hours = {0, 1, 2, 3, 4};
        int target = 2;
        int expected = 3;
        Assertions.assertEquals(expected, solution2798.numberOfEmployeesWhoMetTarget(hours, target));
    }

    @Test
    public void example2() {
        int[] hours = {5, 1, 4, 2, 2};
        int target = 6;
        int expected = 0;
        Assertions.assertEquals(expected, solution2798.numberOfEmployeesWhoMetTarget(hours, target));
    }
}