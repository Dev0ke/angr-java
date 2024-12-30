import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1504Tests {
    private final Solution1504 solution1504 = new Solution1504();

    @Test
    public void example1() {
        int[][] mat = UtUtils.stringToInts2("[[1,0,1],[1,1,0],[1,1,0]]");
        int expected = 13;
        Assertions.assertEquals(expected, solution1504.numSubmat(mat));
    }

    @Test
    public void example2() {
        int[][] mat = UtUtils.stringToInts2("[[0,1,1,0],[0,1,1,1],[1,1,1,0]]");
        int expected = 24;
        Assertions.assertEquals(expected, solution1504.numSubmat(mat));
    }
}