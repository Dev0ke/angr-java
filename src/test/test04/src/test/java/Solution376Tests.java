import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution376Tests {
    private final Solution376 solution376 = new Solution376();

    @Test
    public void example1() {
        int[] nums = {1, 7, 4, 9, 2, 5};
        int expected = 6;
        Assertions.assertEquals(expected, solution376.wiggleMaxLength(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        int expected = 7;
        Assertions.assertEquals(expected, solution376.wiggleMaxLength(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int expected = 2;
        Assertions.assertEquals(expected, solution376.wiggleMaxLength(nums));
    }
}
