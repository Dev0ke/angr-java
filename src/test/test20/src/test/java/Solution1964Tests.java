import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1964Tests {
    private final Solution1964 solution1964 = new Solution1964();

    @Test
    public void example1() {
        int[] obstacles = {1, 2, 3, 2};
        int[] expected = {1, 2, 3, 3};
        Assertions.assertArrayEquals(expected, solution1964.longestObstacleCourseAtEachPosition(obstacles));
    }

    @Test
    public void example2() {
        int[] obstacles = {2, 2, 1};
        int[] expected = {1, 2, 1};
        Assertions.assertArrayEquals(expected, solution1964.longestObstacleCourseAtEachPosition(obstacles));
    }

    @Test
    public void example3() {
        int[] obstacles = {3, 1, 5, 6, 4, 2};
        int[] expected = {1, 1, 2, 3, 2, 2};
        Assertions.assertArrayEquals(expected, solution1964.longestObstacleCourseAtEachPosition(obstacles));
    }

    // 补充用例（感受一下当 n 的值很大时, 时间复杂度所导致的耗时差）
    @Test
    public void example4() {
        int[] obstacles = UtUtils.loadingInts("solution1964-example4-input.txt", 0);
        int[] expected = UtUtils.loadingInts("solution1964-example4-output.txt", 0);
        Assertions.assertArrayEquals(expected, solution1964.longestObstacleCourseAtEachPosition(obstacles));
//        Assertions.assertArrayEquals(expected, solution1964.longestObstacleCourseAtEachPosition2(obstacles));
    }

    @Test
    public void example5() {
        int[] obstacles = UtUtils.loadingInts("solution1964-example5-input.txt", 0);
        int[] expected = UtUtils.loadingInts("solution1964-example5-output.txt", 0);
        Assertions.assertArrayEquals(expected, solution1964.longestObstacleCourseAtEachPosition(obstacles));
//        Assertions.assertArrayEquals(expected, solution1964.longestObstacleCourseAtEachPosition2(obstacles));
    }
}
