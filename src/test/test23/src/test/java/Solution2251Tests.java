import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2251Tests {
    private final Solution2251 solution2251 = new Solution2251();

    @Test
    public void example1() {
        int[][] flowers = UtUtils.stringToInts2("[[1,6],[3,7],[9,12],[4,13]]");
        int[] persons = {2, 3, 7, 11};
        int[] expected = {1, 2, 2, 2};
        Assertions.assertArrayEquals(expected, solution2251.fullBloomFlowers(flowers, persons));
    }

    @Test
    public void example2() {
        int[][] flowers = UtUtils.stringToInts2("[[1,10],[3,3]]");
        int[] persons = {3, 3, 2};
        int[] expected = {2, 2, 1};
        Assertions.assertArrayEquals(expected, solution2251.fullBloomFlowers(flowers, persons));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/309036934/
        // 边界超出 person 看花时间
        int[][] flowers = UtUtils.stringToInts2("[[11,11],[24,46],[3,25],[44,46]]");
        int[] persons = {1, 8, 26, 7, 43, 26, 1};
        int[] expected = {0, 1, 1, 1, 1, 1, 0};
        Assertions.assertArrayEquals(expected, solution2251.fullBloomFlowers(flowers, persons));
    }
}