import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution835Tests {
    private final Solution835 solution835 = new Solution835();

    @Test
    public void example1() {
        int[][] img1 = UtUtils.stringToInts2("[[1,1,0],[0,1,0],[0,1,0]]");
        int[][] img2 = UtUtils.stringToInts2("[[0,0,0],[0,1,1],[0,0,1]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution835.largestOverlap(img1, img2));
    }

    @Test
    public void example2() {
        int[][] img1 = UtUtils.stringToInts2("[[1]]");
        int[][] img2 = UtUtils.stringToInts2("[[1]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution835.largestOverlap(img1, img2));
    }

    @Test
    public void example3() {
        int[][] img1 = UtUtils.stringToInts2("[[0]]");
        int[][] img2 = UtUtils.stringToInts2("[[0]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution835.largestOverlap(img1, img2));
    }
}