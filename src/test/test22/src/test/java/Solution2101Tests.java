import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2101Tests {
    private final Solution2101 solution2101 = new Solution2101();

    @Test
    public void example1() {
        int[][] bombs = UtUtils.stringToInts2("[[2,1,3],[6,1,4]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution2101.maximumDetonation(bombs));
    }

    @Test
    public void example2() {
        int[][] bombs = UtUtils.stringToInts2("[[1,1,5],[10,10,5]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution2101.maximumDetonation(bombs));
    }

    @Test
    public void example3() {
        int[][] bombs = UtUtils.stringToInts2("[[1,2,3],[2,3,1],[3,4,2],[4,5,3],[5,6,4]]");
        int expected = 5;
        Assertions.assertEquals(expected, solution2101.maximumDetonation(bombs));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/247587990/
        // 147 / 160 个通过测试用例
        int[][] bombs = UtUtils.stringToInts2("[[855,82,158],[17,719,430],[90,756,164],[376,17,340],[691,636,152],[565,776,5],[464,154,271],[53,361,162],[278,609,82],[202,927,219],[542,865,377],[330,402,270],[720,199,10],[986,697,443],[471,296,69],[393,81,404],[127,405,177]]");
        int expected = 9;
        Assertions.assertEquals(expected, solution2101.maximumDetonation(bombs));
    }
}
