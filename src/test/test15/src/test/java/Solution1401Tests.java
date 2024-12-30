import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1401Tests {
    private final Solution1401 solution1401 = new Solution1401();

    @Test
    public void example1() {
        int radius = 1;
        int xCenter = 0;
        int yCenter = 0;
        int x1 = 1;
        int y1 = -1;
        int x2 = 3;
        int y2 = 1;
        Assertions.assertTrue(solution1401.checkOverlap(radius, xCenter, yCenter, x1, y1, x2, y2));
    }

    @Test
    public void example2() {
        int radius = 1;
        int xCenter = 1;
        int yCenter = 1;
        int x1 = 1;
        int y1 = -3;
        int x2 = 2;
        int y2 = -1;
        Assertions.assertFalse(solution1401.checkOverlap(radius, xCenter, yCenter, x1, y1, x2, y2));
    }

    @Test
    public void example3() {
        int radius = 1;
        int xCenter = 0;
        int yCenter = 0;
        int x1 = -1;
        int y1 = 0;
        int x2 = 0;
        int y2 = 1;
        Assertions.assertTrue(solution1401.checkOverlap(radius, xCenter, yCenter, x1, y1, x2, y2));
    }
}