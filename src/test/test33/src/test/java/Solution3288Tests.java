import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3288Tests {
    private final Solution3288 solution3288 = new Solution3288();

    @Test
    public void example1() {
        int[][] coordinates = UtUtils.stringToInts2("[[3,1],[2,2],[4,1],[0,0],[5,3]]");
        int k = 1;
        int expected = 3;
        Assertions.assertEquals(expected, solution3288.maxPathLength(coordinates, k));
    }

    @Test
    public void example2() {
        int[][] coordinates = UtUtils.stringToInts2("[[2,1],[7,0],[5,6]]");
        int k = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution3288.maxPathLength(coordinates, k));
    }
}