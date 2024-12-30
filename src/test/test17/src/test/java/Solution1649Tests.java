import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1649Tests {
    private final Solution1649 solution1649 = new Solution1649();

    @Test
    public void example1() {
        int[] instructions = {1, 5, 6, 2};
        int expected = 1;
        Assertions.assertEquals(expected, solution1649.createSortedArray(instructions));
    }

    @Test
    public void example2() {
        int[] instructions = {1, 2, 3, 6, 5, 4};
        int expected = 3;
        Assertions.assertEquals(expected, solution1649.createSortedArray(instructions));
    }

    @Test
    public void example3() {
        int[] instructions = {1, 3, 3, 3, 2, 4, 2, 1, 2};
        int expected = 4;
        Assertions.assertEquals(expected, solution1649.createSortedArray(instructions));
    }
}