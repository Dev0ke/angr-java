import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution661Tests {
    private final Solution661 solution661 = new Solution661();

    @Test
    public void example1() {
        int[][] img = UtUtils.stringToInts2("[[1,1,1],[1,0,1],[1,1,1]]");
        int[][] expected = UtUtils.stringToInts2("[[0, 0, 0],[0, 0, 0], [0, 0, 0]]");
        Assertions.assertArrayEquals(expected, solution661.imageSmoother(img));
    }

    @Test
    public void example2() {
        int[][] img = UtUtils.stringToInts2("[[100,200,100],[200,50,200],[100,200,100]]");
        int[][] expected = UtUtils.stringToInts2("[[137,141,137],[141,138,141],[137,141,137]]");
        Assertions.assertArrayEquals(expected, solution661.imageSmoother(img));
    }
}
