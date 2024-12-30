import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2201Tests {
    private final Solution2201 solution2201 = new Solution2201();

    @Test
    public void example1() {
        int n = 2;
        int[][] artifacts = UtUtils.stringToInts2("[[0,0,0,0],[0,1,1,1]]");
        int[][] dig = UtUtils.stringToInts2("[[0,0],[0,1]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution2201.digArtifacts(n, artifacts, dig));
    }

    @Test
    public void example2() {
        int n = 2;
        int[][] artifacts = UtUtils.stringToInts2("[[0,0,0,0],[0,1,1,1]]");
        int[][] dig = UtUtils.stringToInts2("[[0,0],[0,1],[1,1]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution2201.digArtifacts(n, artifacts, dig));
    }
}
