import org.junit.jupiter.api.Test;

public class Solution398Tests {
    @Test
    public void example1() {
        int[] nums = new int[]{1, 2, 3, 3, 3};
        Solution398.Solution solution = new Solution398.Solution(nums);

        // pick(3) 应该返回索引 2,3 或者 4。每个索引的返回概率应该相等。
        solution.pick(3);

        // pick(1) 应该返回 0。因为只有nums[0]等于1。
        solution.pick(1);
    }
}
