import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1901Tests {
    private final Solution1901 solution1901 = new Solution1901();
    private final Solution1901.V2 solution1901_v2 = new Solution1901.V2();

    @Test
    public void example1() {
        int[][] mat = UtUtils.stringToInts2("[[1,4],[3,2]]");
        int[] expected = {0, 1};
        Assertions.assertArrayEquals(expected, solution1901.findPeakGrid(mat));
        Assertions.assertArrayEquals(expected, solution1901_v2.findPeakGrid(mat));
    }

    @Test
    public void example2() {
        int[][] mat = UtUtils.stringToInts2("[[10,20,15],[21,30,14],[7,16,32]]");
        // 30和32都是顶峰元素，所以[1,1]和[2,2]都是可接受的答案。
        int[] expected = {2, 2};
        Assertions.assertArrayEquals(expected, solution1901.findPeakGrid(mat));
        Assertions.assertArrayEquals(new int[]{1, 1}, solution1901_v2.findPeakGrid(mat));
    }
}
