import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution391Tests {
    private final Solution391 solution391 = new Solution391();

    @Test
    public void example1() {
        int[][] rectangles = UtUtils.stringToInts2("[[1,1,3,3],[3,1,4,2],[3,2,4,4],[1,3,2,4],[2,3,3,4]]");
        Assertions.assertTrue(solution391.isRectangleCover(rectangles));
    }

    @Test
    public void example2() {
        int[][] rectangles = UtUtils.stringToInts2("[[1,1,2,3],[1,3,2,4],[3,1,4,2],[3,2,4,4]]");
        Assertions.assertFalse(solution391.isRectangleCover(rectangles));
    }

    @Test
    public void example3() {
        int[][] rectangles = UtUtils.stringToInts2("[[1,1,3,3],[3,1,4,2],[1,3,2,4],[2,2,4,4]]");
        Assertions.assertFalse(solution391.isRectangleCover(rectangles));
    }
}