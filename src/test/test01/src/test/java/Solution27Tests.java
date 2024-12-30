import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution27Tests {
    private final Solution27 solution27 = new Solution27();

    @Test
    public void example1() {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int expected = 2;
        Assertions.assertEquals(expected, solution27.removeElement(nums, val));
    }

    @Test
    public void example2() {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        int expected = 5;
        Assertions.assertEquals(expected, solution27.removeElement(nums, val));
    }
}
