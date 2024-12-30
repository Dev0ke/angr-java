import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1637Tests {
    private final Solution1637 solution1637 = new Solution1637();

    @Test
    public void example1() {
        int[][] points = UtUtils.stringToInts2("[[8,7],[9,9],[7,4],[9,7]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution1637.maxWidthOfVerticalArea(points));
    }

    @Test
    public void example2() {
        int[][] points = UtUtils.stringToInts2("[[3,1],[9,0],[1,0],[1,4],[5,3],[8,8]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution1637.maxWidthOfVerticalArea(points));
    }
}
