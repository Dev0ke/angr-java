import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SolutionP2664Tests {
    private final SolutionP2664 solutionP2664 = new SolutionP2664();

    @Test
    public void example1() {
        int m = 1;
        int n = 1;
        int r = 0;
        int c = 0;
        int[][] expected = UtUtils.stringToInts2("[[0]]");
        Assertions.assertArrayEquals(expected, solutionP2664.tourOfKnight(m, n, r, c));
    }

    @Test
    public void example2() {
        int m = 3;
        int n = 4;
        int r = 0;
        int c = 0;
//        int[][] expected = UtUtils.stringToInts2("[[0,3,6,9],[11,8,1,4],[2,5,10,7]]");
        // 答案不唯一
        int[][] expected = UtUtils.stringToInts2("[[0, 3, 6, 9], [7, 10, 1, 4], [2, 5, 8, 11]]");
        Assertions.assertArrayEquals(expected, solutionP2664.tourOfKnight(m, n, r, c));
    }
}