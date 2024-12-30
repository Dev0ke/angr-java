import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1806Tests {
    private final Solution1806 solution1806 = new Solution1806();

    @Test
    public void example1() {
        int n = 2;
        int expected = 1;
        Assertions.assertEquals(expected, solution1806.reinitializePermutation(n));
    }

    @Test
    public void example2() {
        int n = 4;
        int expected = 2;
        Assertions.assertEquals(expected, solution1806.reinitializePermutation(n));
    }

    @Test
    public void example3() {
        int n = 6;
        int expected = 4;
        Assertions.assertEquals(expected, solution1806.reinitializePermutation(n));
    }
}
