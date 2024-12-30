import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3283Tests {
    private final Solution3283 solution3283 = new Solution3283();

    @Test
    public void example1() {
        int kx = 1;
        int ky = 1;
        int[][] positions = UtUtils.stringToInts2("[[0,0]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution3283.maxMoves(kx, ky, positions));
    }

    @Test
    public void example2() {
        int kx = 0;
        int ky = 2;
        int[][] positions = UtUtils.stringToInts2("[[1,1],[2,2],[3,3]]");
        int expected = 8;
        Assertions.assertEquals(expected, solution3283.maxMoves(kx, ky, positions));
    }

    @Test
    public void example3() {
        int kx = 0;
        int ky = 0;
        int[][] positions = UtUtils.stringToInts2("[[1,2],[2,4]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution3283.maxMoves(kx, ky, positions));
    }
}