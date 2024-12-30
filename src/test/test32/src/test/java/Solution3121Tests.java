import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3121Tests {
    private final Solution3121 solution3121 = new Solution3121();

    @Test
    public void example1() {
        String word = "aaAbcBC";
        int expected = 3;
        Assertions.assertEquals(expected, solution3121.numberOfSpecialChars(word));
    }

    @Test
    public void example2() {
        String word = "abc";
        int expected = 0;
        Assertions.assertEquals(expected, solution3121.numberOfSpecialChars(word));
    }

    @Test
    public void example3() {
        String word = "AbBCab";
        int expected = 0;
        Assertions.assertEquals(expected, solution3121.numberOfSpecialChars(word));
    }
}