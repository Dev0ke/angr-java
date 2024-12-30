import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution521Tests {
    private final Solution521 solution521 = new Solution521();

    @Test
    public void example1() {
        String a = "aba";
        String b = "cdc";
        int expected = 3;
        Assertions.assertEquals(expected, solution521.findLUSlength(a, b));
    }

    @Test
    public void example2() {
        String a = "aaa";
        String b = "bbb";
        int expected = 3;
        Assertions.assertEquals(expected, solution521.findLUSlength(a, b));
    }

    @Test
    public void example3() {
        String a = "aaa";
        String b = "aaa";
        int expected = -1;
        Assertions.assertEquals(expected, solution521.findLUSlength(a, b));
    }
}
