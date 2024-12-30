import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1494Tests {
    private final Solution1494 solution1494 = new Solution1494();

    @Test
    public void example1() {
        int n = 4;
        int[][] relations = UtUtils.stringToInts2("[[2,1],[3,1],[1,4]]");
        int k = 2;
        int expected = 3;
        Assertions.assertEquals(expected, solution1494.minNumberOfSemesters(n, relations, k));
    }

    @Test
    public void example2() {
        int n = 5;
        int[][] relations = UtUtils.stringToInts2("[[2,1],[3,1],[4,1],[1,5]]");
        int k = 2;
        int expected = 4;
        Assertions.assertEquals(expected, solution1494.minNumberOfSemesters(n, relations, k));
    }

    @Test
    public void example3() {
        int n = 11;
        int[][] relations = UtUtils.stringToInts2("[]");
        int k = 2;
        int expected = 6;
        Assertions.assertEquals(expected, solution1494.minNumberOfSemesters(n, relations, k));
    }
}