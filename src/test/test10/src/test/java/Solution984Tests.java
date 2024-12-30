import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution984Tests {
    private final Solution984 solution984 = new Solution984();

    @Test
    public void example1() {
        int a = 1;
        int b = 2;
//        String expected = "abb";
        String expected = "bab";
        Assertions.assertEquals(expected, solution984.strWithout3a3b(a, b));
    }

    @Test
    public void example2() {
        int a = 4;
        int b = 1;
        String expected = "aabaa";
        Assertions.assertEquals(expected, solution984.strWithout3a3b(a, b));
    }
}