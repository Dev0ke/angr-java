import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution542Tests {
    private final Solution542 solution542 = new Solution542();

    @Test
    public void example1() {
        int[][] mat = UtUtils.stringToInts2("[[0,0,0],[0,1,0],[0,0,0]]");
        int[][] expected = UtUtils.stringToInts2("[[0,0,0],[0,1,0],[0,0,0]]");
        Assertions.assertArrayEquals(expected, solution542.updateMatrix(mat));
    }

    @Test
    public void example2() {
        int[][] mat = UtUtils.stringToInts2("[[0,0,0],[0,1,0],[1,1,1]]");
        int[][] expected = UtUtils.stringToInts2("[[0,0,0],[0,1,0],[1,2,1]]");
        Assertions.assertArrayEquals(expected, solution542.updateMatrix(mat));
    }
}
