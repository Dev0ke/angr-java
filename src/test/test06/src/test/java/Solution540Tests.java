import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution540Tests {
    private final Solution540 solution540 = new Solution540();

    @Test
    public void example1() {
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        int expected = 2;
        Assertions.assertEquals(expected, solution540.singleNonDuplicate(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, 3, 7, 7, 10, 11, 11};
        int expected = 10;
        Assertions.assertEquals(expected, solution540.singleNonDuplicate(nums));
    }
}
