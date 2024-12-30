import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class Solution2528Tests {
    private final Solution2528 solution2528 = new Solution2528();

    @Test
    public void example1() {
        int[] stations = {1, 2, 4, 5, 0};
        int r = 1;
        int k = 2;
        long expected = 5;
        Assertions.assertEquals(expected, solution2528.maxPower(stations, r, k));
    }

    @Test
    public void example2() {
        int[] stations = {4, 4, 4, 4};
        int r = 0;
        int k = 3;
        long expected = 4;
        Assertions.assertEquals(expected, solution2528.maxPower(stations, r, k));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/393698882/ TLE
        String fileName = "solution2528-example3-input.txt";
        int[] stations = UtUtils.loadingInts(fileName, 0);
        int r = UtUtils.loadingInt(fileName, 1);
        int k = UtUtils.loadingInt(fileName, 2);
        long expected = 2704796369L;
        Assertions.assertEquals(expected, solution2528.maxPower(stations, r, k));
    }

    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/393701713/
        // WA 线段树 爆 int
        String fileName = "solution2528-example4-input.txt";
        int[] stations = UtUtils.loadingInts(fileName, 0);
        int r = UtUtils.loadingInt(fileName, 1);
        int k = UtUtils.loadingInt(fileName, 2);
        long expected = 2704796369L;
        Assertions.assertEquals(expected, solution2528.maxPower(stations, r, k));
    }

    @Test
    public void example5() {
        // https://leetcode.cn/submissions/detail/393829754/ TLE
        String fileName = "solution2528-example5-input.txt";
        int[] stations = UtUtils.loadingInts(fileName, 0);
        int r = UtUtils.loadingInt(fileName, 1);
        int k = UtUtils.loadingInt(fileName, 2);
        long expected = 27501;
        Assertions.assertEquals(expected, solution2528.maxPower(stations, r, k));
    }

    @Test
    @Disabled
    public void example3_2() {
        // https://leetcode.cn/submissions/detail/393698882/ TLE
        String fileName = "solution2528-example3-input.txt";
        int[] stations = UtUtils.loadingInts(fileName, 0);
        int r = UtUtils.loadingInt(fileName, 1);
        int k = UtUtils.loadingInt(fileName, 2);
        long expected = 2704796369L;
        Assertions.assertEquals(expected, solution2528.maxPower2(stations, r, k));
    }

    @Test
    @Disabled
    public void example4_2() {
        // https://leetcode.cn/submissions/detail/393701713/
        // WA 线段树 爆 int
        String fileName = "solution2528-example4-input.txt";
        int[] stations = UtUtils.loadingInts(fileName, 0);
        int r = UtUtils.loadingInt(fileName, 1);
        int k = UtUtils.loadingInt(fileName, 2);
        long expected = 2704796369L;
        Assertions.assertEquals(expected, solution2528.maxPower2(stations, r, k));
    }

    @Test
    @Disabled
    public void example5_2() {
        // https://leetcode.cn/submissions/detail/393829754/ TLE
        String fileName = "solution2528-example5-input.txt";
        int[] stations = UtUtils.loadingInts(fileName, 0);
        int r = UtUtils.loadingInt(fileName, 1);
        int k = UtUtils.loadingInt(fileName, 2);
        long expected = 27501;
        Assertions.assertEquals(expected, solution2528.maxPower2(stations, r, k));
    }
}
