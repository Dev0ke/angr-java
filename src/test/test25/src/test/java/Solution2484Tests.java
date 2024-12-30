import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2484Tests {
    private final Solution2484 solution2484 = new Solution2484();

    @Test
    public void example1() {
        String s = "103301";
        int expected = 2;
        Assertions.assertEquals(expected, solution2484.countPalindromes(s));
    }

    @Test
    public void example2() {
        String s = "0000000";
        int expected = 21;
        Assertions.assertEquals(expected, solution2484.countPalindromes(s));
    }

    @Test
    public void example3() {
        String s = "9999900000";
        int expected = 2;
        Assertions.assertEquals(expected, solution2484.countPalindromes(s));
    }
}
