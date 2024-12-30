import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution939Tests {
    private final Solution939 solution939 = new Solution939();

    @Test
    public void example1() {
        int[][] points = UtUtils.stringToInts2("[[1,1],[1,3],[3,1],[3,3],[2,2]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution939.minAreaRect(points));
    }

    @Test
    public void example2() {
        int[][] points = UtUtils.stringToInts2("[[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution939.minAreaRect(points));
    }
}