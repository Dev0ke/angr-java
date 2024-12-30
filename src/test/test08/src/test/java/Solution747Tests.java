import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution747Tests {
    private final Solution747 solution747 = new Solution747();

    @Test
    public void example1() {
        int[] nums = {3, 6, 1, 0};
        int expected = 1;
        Assertions.assertEquals(expected, solution747.dominantIndex(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 4};
        int expected = -1;
        Assertions.assertEquals(expected, solution747.dominantIndex(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1};
        int expected = 0;
        Assertions.assertEquals(expected, solution747.dominantIndex(nums));
    }

    // 补充用例
    @Test
    public void example4() {
        int[] nums = {0, 0, 3, 2};
        int expected = -1;
        Assertions.assertEquals(expected, solution747.dominantIndex(nums));
    }
}
