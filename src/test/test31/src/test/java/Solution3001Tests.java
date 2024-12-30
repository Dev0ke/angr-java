import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3001Tests {
    private final Solution3001 solution3001 = new Solution3001();

    @Test
    public void example1() {
        int a = 1;
        int b = 1;
        int c = 8;
        int d = 8;
        int e = 2;
        int f = 3;
        int expected = 2;
        Assertions.assertEquals(expected, solution3001.minMovesToCaptureTheQueen(a, b, c, d, e, f));
    }

    @Test
    public void example2() {
        int a = 5;
        int b = 3;
        int c = 3;
        int d = 4;
        int e = 5;
        int f = 2;
        int expected = 1;
        Assertions.assertEquals(expected, solution3001.minMovesToCaptureTheQueen(a, b, c, d, e, f));
    }
}