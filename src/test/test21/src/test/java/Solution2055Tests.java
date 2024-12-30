import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2055Tests {
    private final Solution2055 solution2055 = new Solution2055();

    @Test
    public void example1() {
        String s = "**|**|***|";
        int[][] queries = UtUtils.stringToInts2("[[2,5],[5,9]]");
        int[] expected = {2, 3};
        Assertions.assertArrayEquals(expected, solution2055.platesBetweenCandles(s, queries));
    }

    @Test
    public void example2() {
        String s = "***|**|*****|**||**|*";
        int[][] queries = UtUtils.stringToInts2("[[1,17],[4,5],[14,17],[5,11],[15,16]]");
        int[] expected = {9, 0, 0, 0, 0};
        Assertions.assertArrayEquals(expected, solution2055.platesBetweenCandles(s, queries));
    }
}
