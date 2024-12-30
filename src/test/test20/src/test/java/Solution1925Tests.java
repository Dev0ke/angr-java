import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1925Tests {
    private final Solution1925 solution1925 = new Solution1925();

    @Test
    public void example1() {
        int n = 5;
        int expected = 2;
        Assertions.assertEquals(expected, solution1925.countTriples(n));
    }

    @Test
    public void example2() {
        int n = 10;
        int expected = 4;
        Assertions.assertEquals(expected, solution1925.countTriples(n));
    }
}
