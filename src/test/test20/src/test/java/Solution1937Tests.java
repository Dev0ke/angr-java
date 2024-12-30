import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1937Tests {
    private final Solution1937 solution1937 = new Solution1937();

    @Test
    public void example1() {
        int[][] points = UtUtils.stringToInts2("[[1,2,3],[1,5,1],[3,1,1]]");
        long expected = 9;
        Assertions.assertEquals(expected, solution1937.maxPoints(points));
    }

    @Test
    public void example2() {
        int[][] points = UtUtils.stringToInts2("[[1,5],[2,3],[4,2]]");
        long expected = 11;
        Assertions.assertEquals(expected, solution1937.maxPoints(points));
    }
}
