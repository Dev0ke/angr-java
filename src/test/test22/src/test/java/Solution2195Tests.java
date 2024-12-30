import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2195Tests {
    private final Solution2195 solution2195 = new Solution2195();

    @Test
    public void example1() {
        int[] nums = {1, 4, 25, 10, 25};
        int k = 2;
        long expected = 5;
        Assertions.assertEquals(expected, solution2195.minimalKSum(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {5, 6};
        int k = 6;
        long expected = 25;
        Assertions.assertEquals(expected, solution2195.minimalKSum(nums, k));
    }

    // 补充用例
    @Test
    public void example3() {
        int[] nums = {53, 41, 90, 33, 84, 26, 50, 32, 63, 47, 66, 43, 29, 88, 71, 28, 83};
        int k = 76;
        long expected = 3444;
        Assertions.assertEquals(expected, solution2195.minimalKSum(nums, k));
    }

    @Test
    public void example4() {
        int[] nums = {96, 44, 99, 25, 61, 84, 88, 18, 19, 33, 60, 86, 52, 19, 32, 47, 35, 50, 94, 17, 29, 98, 22, 21, 72, 100, 40, 84};
        int k = 35;
        long expected = 794;
        Assertions.assertEquals(expected, solution2195.minimalKSum(nums, k));
    }
}
