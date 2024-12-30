import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2849Tests {
    private final Solution2849 solution2849 = new Solution2849();

    @Test
    public void example1() {
        int sx = 2;
        int sy = 4;
        int fx = 7;
        int fy = 7;
        int t = 6;
        Assertions.assertTrue(solution2849.isReachableAtTime(sx, sy, fx, fy, t));
    }

    @Test
    public void example2() {
        int sx = 3;
        int sy = 1;
        int fx = 7;
        int fy = 3;
        int t = 3;
        Assertions.assertFalse(solution2849.isReachableAtTime(sx, sy, fx, fy, t));
    }

    // 补充用例
    @Test
    public void example3() {
        int sx = 1;
        int sy = 1;
        int fx = 1;
        int fy = 1;
        int t = 1;
        Assertions.assertFalse(solution2849.isReachableAtTime(sx, sy, fx, fy, t));
    }
}