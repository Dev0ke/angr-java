import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution780Tests {
    private final Solution780 solution780 = new Solution780();

    @Test
    public void example1() {
        int sx = 1;
        int sy = 1;
        int tx = 3;
        int ty = 5;
        Assertions.assertTrue(solution780.reachingPoints(sx, sy, tx, ty));
    }

    @Test
    public void example2() {
        int sx = 1;
        int sy = 1;
        int tx = 2;
        int ty = 2;
        Assertions.assertFalse(solution780.reachingPoints(sx, sy, tx, ty));
    }

    @Test
    public void example3() {
        int sx = 1;
        int sy = 1;
        int tx = 1;
        int ty = 1;
        Assertions.assertTrue(solution780.reachingPoints(sx, sy, tx, ty));
    }
}
