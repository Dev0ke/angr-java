import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Solution2463Tests {
    private final Solution2463 solution2463 = new Solution2463();

    @Test
    public void example1() {
        List<Integer> robot = Arrays.asList(0, 4, 6);
        int[][] factory = UtUtils.stringToInts2("[[2,2],[6,2]]");
        long expected = 4;
        Assertions.assertEquals(expected, solution2463.minimumTotalDistance(robot, factory));
        Assertions.assertEquals(expected, solution2463.minimumTotalDistance2(robot, factory));
        Assertions.assertEquals(expected, solution2463.minimumTotalDistance3(robot, factory));
    }

    @Test
    public void example2() {
        List<Integer> robot = Arrays.asList(1, -1);
        int[][] factory = UtUtils.stringToInts2("[[-2,1],[2,1]]");
        long expected = 2;
        Assertions.assertEquals(expected, solution2463.minimumTotalDistance(robot, factory));
        Assertions.assertEquals(expected, solution2463.minimumTotalDistance2(robot, factory));
        Assertions.assertEquals(expected, solution2463.minimumTotalDistance3(robot, factory));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/379724650/
        // KM 算法 TLE
        String fileName = "solution2463-example3-input.txt";
        List<Integer> robot = UtUtils.loadingIntegerList(fileName, 0);
        int[][] factory = UtUtils.loadingInts2(fileName, 1);
        long expected = 876878915;
        Assertions.assertEquals(expected, solution2463.minimumTotalDistance(robot, factory));
        Assertions.assertEquals(expected, solution2463.minimumTotalDistance2(robot, factory));
        Assertions.assertEquals(expected, solution2463.minimumTotalDistance3(robot, factory));
    }
}
