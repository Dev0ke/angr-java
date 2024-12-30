import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3084Tests {
    private final Solution3084 solution3084 = new Solution3084();

    @Test
    public void example1() {
        String s = "abada";
        char c = 'a';
        long expected = 6;
        Assertions.assertEquals(expected, solution3084.countSubstrings(s, c));
    }

    @Test
    public void example2() {
        String s = "zzz";
        char c = 'z';
        long expected = 6;
        Assertions.assertEquals(expected, solution3084.countSubstrings(s, c));
    }
}