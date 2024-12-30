import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3000Tests {
    private final Solution3000 solution3000 = new Solution3000();

    @Test
    public void example1() {
        int[][] dimensions = UtUtils.stringToInts2("[[9,3],[8,6]]");
        int expected = 48;
        Assertions.assertEquals(expected, solution3000.areaOfMaxDiagonal(dimensions));
    }

    @Test
    public void example2() {
        int[][] dimensions = UtUtils.stringToInts2("[[3,4],[4,3]]");
        int expected = 12;
        Assertions.assertEquals(expected, solution3000.areaOfMaxDiagonal(dimensions));
    }
}