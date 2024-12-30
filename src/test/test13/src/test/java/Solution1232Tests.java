import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1232Tests {
    private final Solution1232 solution1232 = new Solution1232();

    @Test
    public void example1() {
        int[][] coordinates = UtUtils.stringToInts2("[[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]");
        Assertions.assertTrue(solution1232.checkStraightLine(coordinates));
    }

    @Test
    public void example2() {
        int[][] coordinates = UtUtils.stringToInts2("[[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]");
        Assertions.assertFalse(solution1232.checkStraightLine(coordinates));
    }
}
