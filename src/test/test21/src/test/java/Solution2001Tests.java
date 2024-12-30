import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2001Tests {
    private final Solution2001 solution2001 = new Solution2001();

    @Test
    public void example1() {
        int[][] rectangles = UtUtils.stringToInts2("[[4,8],[3,6],[10,20],[15,30]]");
        long expected = 6;
        Assertions.assertEquals(expected, solution2001.interchangeableRectangles(rectangles));
    }

    @Test
    public void example2() {
        int[][] rectangles = UtUtils.stringToInts2("[[4,5],[7,8]]");
        long expected = 0;
        Assertions.assertEquals(expected, solution2001.interchangeableRectangles(rectangles));
    }
}
