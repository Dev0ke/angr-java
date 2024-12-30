import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution447Tests {
    private final Solution447 solution447 = new Solution447();

    @Test
    public void example1() {
        int[][] points = UtUtils.stringToInts2("[[0,0],[1,0],[2,0]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution447.numberOfBoomerangs(points));
    }

    @Test
    public void example2() {
        int[][] points = UtUtils.stringToInts2("[[1,1],[2,2],[3,3]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution447.numberOfBoomerangs(points));
    }

    @Test
    public void example3() {
        int[][] points = UtUtils.stringToInts2("[[1,1]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution447.numberOfBoomerangs(points));
    }
}
