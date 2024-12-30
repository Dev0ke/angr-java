import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1015Tests {
    private final Solution1015 solution1015 = new Solution1015();

    @Test
    public void example1() {
        int k = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solution1015.smallestRepunitDivByK(k));
    }

    @Test
    public void example2() {
        int k = 2;
        int expected = -1;
        Assertions.assertEquals(expected, solution1015.smallestRepunitDivByK(k));
    }

    @Test
    public void example3() {
        int k = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution1015.smallestRepunitDivByK(k));
    }
}