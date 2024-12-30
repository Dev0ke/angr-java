import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1386Tests {
    private final Solution1386 solution1386 = new Solution1386();

    @Test
    public void example1() {
        int n = 3;
        int[][] reservedSeats = UtUtils.stringToInts2("[[1,2],[1,3],[1,8],[2,6],[3,1],[3,10]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution1386.maxNumberOfFamilies(n, reservedSeats));
    }

    @Test
    public void example2() {
        int n = 2;
        int[][] reservedSeats = UtUtils.stringToInts2("[[2,1],[1,8],[2,6]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution1386.maxNumberOfFamilies(n, reservedSeats));
    }

    @Test
    public void example3() {
        int n = 4;
        int[][] reservedSeats = UtUtils.stringToInts2("[[4,3],[1,4],[4,6],[1,7]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution1386.maxNumberOfFamilies(n, reservedSeats));
    }
}