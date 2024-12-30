import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution593Tests {
    private final Solution593 solution593 = new Solution593();

    @Test
    public void example1() {
        int[] p1 = {0, 0};
        int[] p2 = {1, 1};
        int[] p3 = {1, 0};
        int[] p4 = {0, 1};
        Assertions.assertTrue(solution593.validSquare(p1, p2, p3, p4));
    }

    @Test
    public void example2() {
        int[] p1 = {0, 0};
        int[] p2 = {1, 1};
        int[] p3 = {1, 0};
        int[] p4 = {0, 12};
        Assertions.assertFalse(solution593.validSquare(p1, p2, p3, p4));
    }

    @Test
    public void example3() {
        int[] p1 = {1, 0};
        int[] p2 = {-1, 0};
        int[] p3 = {0, 1};
        int[] p4 = {0, -1};
        Assertions.assertTrue(solution593.validSquare(p1, p2, p3, p4));
    }

    // 补充用例
    @Test
    public void example4() {
        int[] p1 = {0, 0};
        int[] p2 = {5, 0};
        int[] p3 = {5, 4};
        int[] p4 = {0, 4};
        Assertions.assertFalse(solution593.validSquare(p1, p2, p3, p4));
    }

    @Test
    public void example5() {
        int[] p1 = {0, 0};
        int[] p2 = {0, 0};
        int[] p3 = {0, 0};
        int[] p4 = {0, 0};
        Assertions.assertFalse(solution593.validSquare(p1, p2, p3, p4));
    }
}
