import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3303Tests {
    private final Solution3303 solution3303 = new Solution3303();

    @Test
    public void example1() {
        String s = "abcdefg";
        String pattern = "bcdffg";
        int expected = 1;
        Assertions.assertEquals(expected, solution3303.minStartingIndex(s, pattern));
    }

    @Test
    public void example2() {
        String s = "ababbababa";
        String pattern = "bacaba";
        int expected = 4;
        Assertions.assertEquals(expected, solution3303.minStartingIndex(s, pattern));
    }

    @Test
    public void example3() {
        String s = "abcd";
        String pattern = "dba";
        int expected = -1;
        Assertions.assertEquals(expected, solution3303.minStartingIndex(s, pattern));
    }

    @Test
    public void example4() {
        String s = "dde";
        String pattern = "d";
        int expected = 0;
        Assertions.assertEquals(expected, solution3303.minStartingIndex(s, pattern));
    }
}