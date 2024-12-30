import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1819Tests {
    private final Solution1819 solution1819 = new Solution1819();

    @Test
    public void example1() {
        int[] nums = {6, 10, 3};
        int expected = 5;
        Assertions.assertEquals(expected, solution1819.countDifferentSubsequenceGCDs(nums));
        Assertions.assertEquals(expected, solution1819.countDifferentSubsequenceGCDs2(nums));
    }

    @Test
    public void example2() {
        int[] nums = {5, 15, 40, 5, 6};
        int expected = 7;
        Assertions.assertEquals(expected, solution1819.countDifferentSubsequenceGCDs(nums));
        Assertions.assertEquals(expected, solution1819.countDifferentSubsequenceGCDs2(nums));
    }
}