import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution832Tests {
    private final Solution832 solution832 = new Solution832();

    @Test
    public void example1() {
        int[][] image = UtUtils.stringToInts2("[[1,1,0],[1,0,1],[0,0,0]]");
        int[][] expected = UtUtils.stringToInts2("[[1,0,0],[0,1,0],[1,1,1]]");
        Assertions.assertArrayEquals(expected, solution832.flipAndInvertImage(image));
    }

    @Test
    public void example2() {
        int[][] image = UtUtils.stringToInts2("[[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]");
        int[][] expected = UtUtils.stringToInts2("[[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]");
        Assertions.assertArrayEquals(expected, solution832.flipAndInvertImage(image));
    }
}
