import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1985Tests {
    private final Solution1985 solution1985 = new Solution1985();

    @Test
    public void example1() {
        String[] nums = {"3", "6", "7", "10"};
        int k = 4;
        String expected = "3";
        Assertions.assertEquals(expected, solution1985.kthLargestNumber(nums, k));
    }

    @Test
    public void example2() {
        String[] nums = {"2", "21", "12", "1"};
        int k = 3;
        String expected = "2";
        Assertions.assertEquals(expected, solution1985.kthLargestNumber(nums, k));
    }

    @Test
    public void example3() {
        String[] nums = {"0", "0"};
        int k = 2;
        String expected = "0";
        Assertions.assertEquals(expected, solution1985.kthLargestNumber(nums, k));
    }
}
