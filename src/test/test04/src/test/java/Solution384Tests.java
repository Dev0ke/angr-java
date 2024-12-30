import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution384Tests {
    @Test
    public void example1() {
        int[] nums = {1, 2, 3};
        Solution384.Solution solution = new Solution384.Solution(nums);

        // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。例如，返回 [3, 1, 2]
        solution.shuffle();

        // 重设数组到它的初始状态 [1, 2, 3] 。返回 [1, 2, 3]
        Assertions.assertArrayEquals(nums, solution.reset());

        // 随机返回数组 [1, 2, 3] 打乱后的结果。例如，返回 [1, 3, 2]
        solution.shuffle();
    }
}
