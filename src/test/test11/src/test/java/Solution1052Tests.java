import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1052Tests {
    private final Solution1052 solution1052 = new Solution1052();

    @Test
    public void example1() {
        int[] customers = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grump = {0, 1, 0, 1, 0, 1, 0, 1};
        int minutes = 3;
        int expected = 16;
        Assertions.assertEquals(expected, solution1052.maxSatisfied(customers, grump, minutes));
    }

    @Test
    public void example2() {
        int[] customers = {1};
        int[] grump = {0};
        int minutes = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solution1052.maxSatisfied(customers, grump, minutes));
    }
}
