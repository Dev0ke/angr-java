import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2545Tests {
    private final Solution2545 solution2545 = new Solution2545();

    @Test
    public void example1() {
        int[][] score = UtUtils.stringToInts2("[[10,6,9,1],[7,5,11,2],[4,8,3,15]]");
        int k = 2;
        int[][] expected = UtUtils.stringToInts2("[[7,5,11,2],[10,6,9,1],[4,8,3,15]]");
        Assertions.assertArrayEquals(expected, solution2545.sortTheStudents(score, k));
    }

    @Test
    public void example2() {
        int[][] score = UtUtils.stringToInts2("[[3,4],[5,6]]");
        int k = 0;
        int[][] expected = UtUtils.stringToInts2("[[5,6],[3,4]]");
        Assertions.assertArrayEquals(expected, solution2545.sortTheStudents(score, k));
    }
}