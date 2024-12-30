import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1591Tests {
    private final Solution1591 solution1591 = new Solution1591();

    @Test
    public void example1() {
        int[][] targetGrid = UtUtils.stringToInts2("[[1,1,1,1],[1,2,2,1],[1,2,2,1],[1,1,1,1]]");
        Assertions.assertTrue(solution1591.isPrintable(targetGrid));
    }

    @Test
    public void example2() {
        int[][] targetGrid = UtUtils.stringToInts2("[[1,1,1,1],[1,1,3,3],[1,1,3,4],[5,5,1,4]]");
        Assertions.assertTrue(solution1591.isPrintable(targetGrid));
    }

    @Test
    public void example3() {
        int[][] targetGrid = UtUtils.stringToInts2("[[1,2,1],[2,1,2],[1,2,1]]");
        Assertions.assertFalse(solution1591.isPrintable(targetGrid));
    }

    @Test
    public void example4() {
        int[][] targetGrid = UtUtils.stringToInts2("[[1,1,1],[3,1,3]]");
        Assertions.assertFalse(solution1591.isPrintable(targetGrid));
    }
}
