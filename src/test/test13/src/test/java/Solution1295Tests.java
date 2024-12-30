import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1295Tests {
    private final Solution1295 solution1295 = new Solution1295();

    @Test
    public void example1() {
        int[] nums = {12, 345, 2, 6, 7896};
        int expected = 2;
        Assertions.assertEquals(expected, solution1295.findNumbers(nums));
    }

    @Test
    public void example2() {
        int[] nums = {555, 901, 482, 1771};
        int expected = 1;
        Assertions.assertEquals(expected, solution1295.findNumbers(nums));
    }
}