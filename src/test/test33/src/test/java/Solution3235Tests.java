import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3235Tests {
    private final Solution3235.V2 solution = new Solution3235.V2();

    @Test
    public void example1() {
        int xCorner = 3;
        int yCorner = 4;
        int[][] circles = UtUtils.stringToInts2("[[2,1,1]]");
        Assertions.assertTrue(solution.canReachCorner(xCorner, yCorner, circles));
    }

    @Test
    public void example2() {
        int xCorner = 3;
        int yCorner = 3;
        int[][] circles = UtUtils.stringToInts2("[[1,1,2]]");
        Assertions.assertFalse(solution.canReachCorner(xCorner, yCorner, circles));
    }

    @Test
    public void example3() {
        int xCorner = 3;
        int yCorner = 3;
        int[][] circles = UtUtils.stringToInts2("[[2,1,1],[1,2,1]]");
        Assertions.assertFalse(solution.canReachCorner(xCorner, yCorner, circles));
    }

    @Test
    public void example4() {
        int xCorner = 4;
        int yCorner = 4;
        int[][] circles = UtUtils.stringToInts2("[[5,5,1]]");
        Assertions.assertTrue(solution.canReachCorner(xCorner, yCorner, circles));
    }
}