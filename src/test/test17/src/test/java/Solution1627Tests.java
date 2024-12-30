import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1627Tests {
    private final Solution1627 solution1627 = new Solution1627();

    @Test
    public void example1() {
        int n = 6;
        int threshold = 2;
        int[][] queries = UtUtils.stringToInts2("[[1,4],[2,5],[3,6]]");
        List<Boolean> expected = List.of(false, false, true);
        Assertions.assertEquals(expected, solution1627.areConnected(n, threshold, queries));
        Assertions.assertEquals(expected, solution1627.areConnected2(n, threshold, queries));
    }

    @Test
    public void example2() {
        int n = 6;
        int threshold = 0;
        int[][] queries = UtUtils.stringToInts2("[[4,5],[3,4],[3,2],[2,6],[1,3]]");
        List<Boolean> expected = List.of(true, true, true, true, true);
        Assertions.assertEquals(expected, solution1627.areConnected(n, threshold, queries));
        Assertions.assertEquals(expected, solution1627.areConnected2(n, threshold, queries));
    }

    @Test
    public void example3() {
        int n = 5;
        int threshold = 1;
        int[][] queries = UtUtils.stringToInts2("[[4,5],[4,5],[3,2],[2,3],[3,4]]");
        List<Boolean> expected = List.of(false, false, false, false, false);
        Assertions.assertEquals(expected, solution1627.areConnected(n, threshold, queries));
        Assertions.assertEquals(expected, solution1627.areConnected2(n, threshold, queries));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/290844058/
        // 66 / 67 个通过测试用例
        String fileName = "solution1627-example4-input.txt";
        int n = UtUtils.loadingInt(fileName, 0);
        int threshold = UtUtils.loadingInt(fileName, 1);
        int[][] queries = UtUtils.loadingInts2(fileName, 2);
        List<Boolean> expected = UtUtils.loadingBooleanList("solution1627-example4-output.txt", 0);
        Assertions.assertEquals(expected, solution1627.areConnected2(n, threshold, queries));
    }
}
