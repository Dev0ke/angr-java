import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution982Tests {
    private final Solution982 solution982 = new Solution982();

    @Test
    public void example1() {
        int[] nums = {2, 1, 3};
        int expected = 12;
        Assertions.assertEquals(expected, solution982.countTriplets(nums));
    }

    @Test
    public void example2() {
        int[] nums = {0, 0, 0};
        int expected = 27;
        Assertions.assertEquals(expected, solution982.countTriplets(nums));
    }
}