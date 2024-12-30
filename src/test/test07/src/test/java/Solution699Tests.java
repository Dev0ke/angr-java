import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution699Tests {
    private final Solution699 solution699 = new Solution699();

    @Test
    public void example1() {
        int[][] positions = UtUtils.stringToInts2("[[1,2],[2,3],[6,1]]");
        List<Integer> expected = List.of(2, 5, 5);
        Assertions.assertEquals(expected, solution699.fallingSquares(positions));
    }

    @Test
    public void example2() {
        int[][] positions = UtUtils.stringToInts2("[[100,100],[200,100]]");
        List<Integer> expected = List.of(100, 100);
        Assertions.assertEquals(expected, solution699.fallingSquares(positions));
    }

    // 补充用例
    @Test
    public void example3() {
        int[][] positions = UtUtils.stringToInts2("[[1,2],[1,3]]");
        List<Integer> expected = List.of(2, 5);
        Assertions.assertEquals(expected, solution699.fallingSquares(positions));
    }
}
