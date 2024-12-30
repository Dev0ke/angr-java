import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution605Tests {
    private final Solution605 solution605 = new Solution605();

    @Test
    public void example1() {
        int[] flowerbed = {1, 0, 0, 0, 1};
        int n = 1;
        Assertions.assertTrue(solution605.canPlaceFlowers(flowerbed, n));
    }

    @Test
    public void example2() {
        int[] flowerbed = {1, 0, 0, 0, 1};
        int n = 2;
        Assertions.assertFalse(solution605.canPlaceFlowers(flowerbed, n));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/389917767/
        int[] flowerbed = {1, 0, 0, 0, 1, 0, 0};
        int n = 2;
        Assertions.assertTrue(solution605.canPlaceFlowers(flowerbed, n));
    }

    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/389917963/
        int[] flowerbed = {0};
        int n = 1;
        Assertions.assertTrue(solution605.canPlaceFlowers(flowerbed, n));
    }
}