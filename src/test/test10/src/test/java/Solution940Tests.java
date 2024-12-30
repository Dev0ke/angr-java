import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution940Tests {
    private final Solution940 solution940 = new Solution940();

    @Test
    public void example1() {
        String s = "abc";
        int expected = 7;
        Assertions.assertEquals(expected, solution940.distinctSubseqII(s));
    }

    @Test
    public void example2() {
        String s = "aba";
        int expected = 6;
        Assertions.assertEquals(expected, solution940.distinctSubseqII(s));
    }

    @Test
    public void example3() {
        String s = "aaa";
        int expected = 3;
        Assertions.assertEquals(expected, solution940.distinctSubseqII(s));
    }
}
