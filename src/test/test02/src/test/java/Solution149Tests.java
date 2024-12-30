import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution149Tests {
    private final Solution149 solution149 = new Solution149();

    @Test
    public void example1() {
        int[][] points = UtUtils.stringToInts2("[[1,1],[2,2],[3,3]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution149.maxPoints(points));
    }

    @Test
    public void example2() {
        int[][] points = UtUtils.stringToInts2("[[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution149.maxPoints(points));
    }
}
