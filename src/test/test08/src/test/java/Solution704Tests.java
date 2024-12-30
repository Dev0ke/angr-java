import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution704Tests {
    private final Solution704 solution704 = new Solution704();

    @Test
    public void example1() {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        int expected = 4;
        Assertions.assertEquals(expected, solution704.search(nums, target));
    }

    @Test
    public void example2() {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 2;
        int expected = -1;
        Assertions.assertEquals(expected, solution704.search(nums, target));
    }
}
