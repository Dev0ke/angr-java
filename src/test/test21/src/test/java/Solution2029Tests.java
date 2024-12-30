import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2029Tests {
    private final Solution2029 solution2029 = new Solution2029();

    @Test
    public void example1() {
        int[] stones = {2, 1};
        Assertions.assertTrue(solution2029.stoneGameIX(stones));
    }

    @Test
    public void example2() {
        int[] stones = {2};
        Assertions.assertFalse(solution2029.stoneGameIX(stones));
    }

    @Test
    public void example3() {
        int[] stones = {5, 1, 2, 4, 3};
        Assertions.assertFalse(solution2029.stoneGameIX(stones));
    }

    // 补充用例
    @Test
    public void example4() {
        int[] stones = {3, 3};
        Assertions.assertFalse(solution2029.stoneGameIX(stones));
    }

    @Test
    public void example5() {
        int[] stones = {20, 3, 20, 17, 2, 12, 15, 17, 4};
        Assertions.assertTrue(solution2029.stoneGameIX(stones));
    }

    @Test
    public void example6() {
        int[] stones = {2, 3};
        Assertions.assertFalse(solution2029.stoneGameIX(stones));
    }

    @Test
    public void example7() {
        int[] stones = {2, 2, 3};
        Assertions.assertFalse(solution2029.stoneGameIX(stones));
    }

    @Test
    public void example8() {
        int[] stones = {15, 20, 10, 13, 14, 15, 5, 2, 3};
        Assertions.assertFalse(solution2029.stoneGameIX(stones));
    }
}
