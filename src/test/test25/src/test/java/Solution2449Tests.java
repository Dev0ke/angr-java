import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2449Tests {
    private final Solution2449 solution2449 = new Solution2449();

    @Test
    public void example1() {
        int[] nums = {8, 12, 6};
        int[] target = {2, 14, 10};
        long expected = 2;
        Assertions.assertEquals(expected, solution2449.makeSimilar(nums, target));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 5};
        int[] target = {4, 1, 3};
        long expected = 1;
        Assertions.assertEquals(expected, solution2449.makeSimilar(nums, target));
    }

    @Test
    public void example3() {
        int[] nums = {1, 1, 1, 1, 1};
        int[] target = {1, 1, 1, 1, 1};
        long expected = 0;
        Assertions.assertEquals(expected, solution2449.makeSimilar(nums, target));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/375636828/
        int[] nums = {758, 334, 402, 1792, 1112, 1436, 1534, 1702, 1538, 1427, 720, 1424, 114, 1604, 564, 120, 578};
        int[] target = {1670, 216, 1392, 1828, 1104, 464, 678, 1134, 644, 1178, 1150, 1608, 1799, 1156, 244, 2, 892};
        long expected = 645;
        Assertions.assertEquals(expected, solution2449.makeSimilar(nums, target));
    }
}
