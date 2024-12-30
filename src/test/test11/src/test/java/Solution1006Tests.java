import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1006Tests {
    private final Solution1006 solution1006 = new Solution1006();

    @Test
    public void example1() {
        int n = 4;
        int expected = 7;
        Assertions.assertEquals(expected, solution1006.clumsy(n));
    }

    @Test
    public void example2() {
        int n = 10;
        int expected = 12;
        Assertions.assertEquals(expected, solution1006.clumsy(n));
    }
}