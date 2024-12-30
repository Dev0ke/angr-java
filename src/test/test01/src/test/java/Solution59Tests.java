import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution59Tests {
    private final Solution59 solution59 = new Solution59();

    @Test
    public void example1() {
        int n = 3;
        int[][] expected = UtUtils.stringToInts2("[[1,2,3],[8,9,4],[7,6,5]]");
        Assertions.assertArrayEquals(expected, solution59.generateMatrix(n));
    }

    @Test
    public void example2() {
        int n = 1;
        int[][] expected = UtUtils.stringToInts2("[[1]]");
        Assertions.assertArrayEquals(expected, solution59.generateMatrix(n));
    }
}
