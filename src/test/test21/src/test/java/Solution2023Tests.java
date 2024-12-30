import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2023Tests {
    private final Solution2023 solution2023 = new Solution2023();

    @Test
    public void example1() {
        String[] nums = {"777", "7", "77", "77"};
        String target = "7777";
        int expected = 4;
        Assertions.assertEquals(expected, solution2023.numOfPairs(nums, target));
    }

    @Test
    public void example2() {
        String[] nums = {"123", "4", "12", "34"};
        String target = "1234";
        int expected = 2;
        Assertions.assertEquals(expected, solution2023.numOfPairs(nums, target));
    }

    @Test
    public void example3() {
        String[] nums = {"1", "1", "1"};
        String target = "11";
        int expected = 6;
        Assertions.assertEquals(expected, solution2023.numOfPairs(nums, target));
    }
}
