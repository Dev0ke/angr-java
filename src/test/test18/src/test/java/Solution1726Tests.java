import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1726Tests {
    private final Solution1726 solution1726 = new Solution1726();

    @Test
    public void example1() {
        int[] nums = {2, 3, 4, 6};
        int expected = 8;
        Assertions.assertEquals(expected, solution1726.tupleSameProduct(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 4, 5, 10};
        int expected = 16;
        Assertions.assertEquals(expected, solution1726.tupleSameProduct(nums));
    }
}