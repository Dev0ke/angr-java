import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1037Tests {
    private final Solution1037 solution1037 = new Solution1037();

    @Test
    public void example1() {
        int[][] points = UtUtils.stringToInts2("[[1,1],[2,3],[3,2]]");
        Assertions.assertTrue(solution1037.isBoomerang(points));
    }

    @Test
    public void example2() {
        int[][] points = UtUtils.stringToInts2("[[1,1],[2,2],[3,3]]");
        Assertions.assertFalse(solution1037.isBoomerang(points));
    }
}
