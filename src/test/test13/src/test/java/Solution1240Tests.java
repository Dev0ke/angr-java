import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1240Tests {
    private final Solution1240 solution1240 = new Solution1240();

    @Test
    public void example1() {
        int n = 2;
        int m = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution1240.tilingRectangle(n, m));
    }

    @Test
    public void example2() {
        int n = 5;
        int m = 8;
        int expected = 5;
        Assertions.assertEquals(expected, solution1240.tilingRectangle(n, m));
    }

    @Test
    public void example3() {
        int n = 11;
        int m = 13;
        int expected = 6;
        Assertions.assertEquals(expected, solution1240.tilingRectangle(n, m));
    }
}