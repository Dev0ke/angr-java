import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1582Tests {
    private final Solution1582 solution1582 = new Solution1582();

    @Test
    public void example1() {
        int[][] mat = UtUtils.stringToInts2("""
                [[1,0,0],
                 [0,0,1],
                 [1,0,0]]
                """);
        int expected = 1;
        Assertions.assertEquals(expected, solution1582.numSpecial(mat));
    }

    @Test
    public void example2() {
        int[][] mat = UtUtils.stringToInts2("""
                [[1,0,0],
                 [0,1,0],
                 [0,0,1]]
                """);
        int expected = 3;
        Assertions.assertEquals(expected, solution1582.numSpecial(mat));
    }

    @Test
    public void example3() {
        int[][] mat = UtUtils.stringToInts2("""
                [[0,0,0,1],
                 [1,0,0,0],
                 [0,1,1,0],
                 [0,0,0,0]]
                """);
        int expected = 2;
        Assertions.assertEquals(expected, solution1582.numSpecial(mat));
    }

    @Test
    public void example4() {
        int[][] mat = UtUtils.stringToInts2("""
                [[0,0,0,0,0],
                 [1,0,0,0,0],
                 [0,1,0,0,0],
                 [0,0,1,0,0],
                 [0,0,0,1,1]]
                """);
        int expected = 3;
        Assertions.assertEquals(expected, solution1582.numSpecial(mat));
    }
}
