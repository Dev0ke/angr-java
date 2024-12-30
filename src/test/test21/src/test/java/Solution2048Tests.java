import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2048Tests {
    private final Solution2048 solution2048 = new Solution2048();

    @Test
    public void example1() {
        int n = 1;
        int expected = 22;
        Assertions.assertEquals(expected, solution2048.nextBeautifulNumber(n));
        Assertions.assertEquals(expected, solution2048.nextBeautifulNumber2(n));
    }

    @Test
    public void example2() {
        int n = 1000;
        int expected = 1333;
        Assertions.assertEquals(expected, solution2048.nextBeautifulNumber(n));
        Assertions.assertEquals(expected, solution2048.nextBeautifulNumber2(n));
    }

    @Test
    public void example3() {
        int n = 3000;
        int expected = 3133;
        Assertions.assertEquals(expected, solution2048.nextBeautifulNumber(n));
        Assertions.assertEquals(expected, solution2048.nextBeautifulNumber2(n));
    }
}
