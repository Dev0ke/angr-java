import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2245Tests {
    private final Solution2245 solution2245 = new Solution2245();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[23,17,15,3,20],[8,1,20,27,11],[9,4,6,2,21],[40,9,1,10,6],[22,7,4,5,3]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution2245.maxTrailingZeros(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[4,3,2],[7,6,1],[8,8,8]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution2245.maxTrailingZeros(grid));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/301231047/
        // 爆 long
        int[][] grid = UtUtils.stringToInts2("[[824,709,193,413,701,836,727],[135,844,599,211,140,933,205],[329,68,285,282,301,387,231],[293,210,478,352,946,902,137],[806,900,290,636,589,522,611],[450,568,990,592,992,128,92],[780,653,795,457,980,942,927],[849,901,604,906,912,866,688]]");
        int expected = 6;
        Assertions.assertEquals(expected, solution2245.maxTrailingZeros(grid));
    }

    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/301241795/
        // BigInteger TLE
        int[][] grid = UtUtils.loadingInts2("solution2245-example4-input.txt", 0);
        int expected = 203;
        Assertions.assertEquals(expected, solution2245.maxTrailingZeros(grid));
    }
}