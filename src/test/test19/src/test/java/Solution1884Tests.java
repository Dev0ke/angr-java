import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1884Tests {
    private final Solution1884 solution1884 = new Solution1884();

    @Test
    public void example1() {
        int n = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution1884.twoEggDrop(n));
    }

    @Test
    public void example2() {
        int n = 100;
        int expected = 14;
        Assertions.assertEquals(expected, solution1884.twoEggDrop(n));
    }
}
