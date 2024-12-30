import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1631Tests {
    private final Solution1631 solution1631 = new Solution1631();

    @Test
    public void example1() {
        int[][] heights = UtUtils.stringToInts2("[[1,2,2],[3,8,2],[5,3,5]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution1631.minimumEffortPath(heights));
    }

    @Test
    public void example2() {
        int[][] heights = UtUtils.stringToInts2("[[1,2,3],[3,8,4],[5,3,5]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution1631.minimumEffortPath(heights));
    }

    @Test
    public void example3() {
        int[][] heights = UtUtils.stringToInts2("[[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution1631.minimumEffortPath(heights));
    }
}
