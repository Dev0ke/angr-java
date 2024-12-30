import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1725Tests {
    private final Solution1725 solution1725 = new Solution1725();

    @Test
    public void example1() {
        int[][] rectangles = UtUtils.stringToInts2("[[5,8],[3,9],[5,12],[16,5]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution1725.countGoodRectangles(rectangles));
    }

    @Test
    public void example2() {
        int[][] rectangles = UtUtils.stringToInts2("[[2,3],[3,7],[4,3],[3,7]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution1725.countGoodRectangles(rectangles));
    }
}
