import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1782Tests {
    private final Solution1782 solution1782 = new Solution1782();

    @Test
    public void example1() {
        int n = 4;
        int[][] edges = UtUtils.stringToInts2("[[1,2],[2,4],[1,3],[2,3],[2,1]]");
        int[] queries = {2, 3};
        int[] expected = {6, 5};
        Assertions.assertArrayEquals(expected, solution1782.countPairs(n, edges, queries));
        Assertions.assertArrayEquals(expected, solution1782.countPairs2(n, edges, queries));
    }

    @Test
    public void example2() {
        int n = 5;
        int[][] edges = UtUtils.stringToInts2("[[1,5],[1,5],[3,4],[2,5],[1,3],[5,1],[2,3],[2,5]]");
        int[] queries = {1, 2, 3, 4, 5};
        int[] expected = {10, 10, 9, 8, 6};
        Assertions.assertArrayEquals(expected, solution1782.countPairs(n, edges, queries));
        Assertions.assertArrayEquals(expected, solution1782.countPairs2(n, edges, queries));
    }

    // 补充用例
    @Test
    public void example3() {
        int n = 5;
        int[][] edges = UtUtils.stringToInts2("[[4,5],[1,3],[1,4]]");
        int[] queries = {0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 2};
        int[] expected = {10, 8, 10, 10, 8, 8, 10, 10, 10, 10, 8, 10, 10, 8, 10, 8, 8, 3};
        Assertions.assertArrayEquals(expected, solution1782.countPairs(n, edges, queries));
    }

    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/324099044/ TLE
        String fileName = "solution1782-example4-input.txt";
        int n = UtUtils.loadingInt(fileName, 0);
        int[][] edges = UtUtils.loadingInts2(fileName, 1);
        int[] queries = UtUtils.loadingInts(fileName, 2);
        int[] expected = {42, 11503, 4366268, 1713097, 246, 2460297, 8642312, 1371, 252911, 142392, 434462, 3362352, 5747, 5747, 8642312, 0, 0, 0, 0};
        Assertions.assertArrayEquals(expected, solution1782.countPairs(n, edges, queries));
    }

    @Test
    public void example5() {
        // https://leetcode.cn/submissions/detail/333107403/ TLE
        String fileName = "solution1782-example5-input.txt";
        int n = UtUtils.loadingInt(fileName, 0);
        int[][] edges = UtUtils.loadingInts2(fileName, 1);
        int[] queries = UtUtils.loadingInts(fileName, 2);
        int[] expected = {3153795, 2560508, 2008211, 3273785, 3479333, 362, 3273785, 147, 3486120, 2560508, 362, 3415093, 3479333, 42958, 112246, 0, 0, 0};
        Assertions.assertArrayEquals(expected, solution1782.countPairs(n, edges, queries));
    }
}