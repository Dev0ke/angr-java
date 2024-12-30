import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1840Tests {
    private final Solution1840 solution1840 = new Solution1840();

    @Test
    public void example1() {
        int n = 5;
        int[][] restrictions = UtUtils.stringToInts2("[[2,1],[4,1]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution1840.maxBuilding(n, restrictions));
    }

    @Test
    public void example2() {
        int n = 6;
        int[][] restrictions = UtUtils.stringToInts2("[]");
        int expected = 5;
        Assertions.assertEquals(expected, solution1840.maxBuilding(n, restrictions));
    }

    @Test
    public void example3() {
        int n = 10;
        int[][] restrictions = UtUtils.stringToInts2("[[5,3],[2,5],[7,4],[10,3]]");
        int expected = 5;
        Assertions.assertEquals(expected, solution1840.maxBuilding(n, restrictions));
    }
}