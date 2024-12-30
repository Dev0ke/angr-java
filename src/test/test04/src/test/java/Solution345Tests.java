import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution345Tests {
    private final Solution345 solution345 = new Solution345();

    @Test
    public void example1() {
        String s = "hello";
        String expected = "holle";
        Assertions.assertEquals(expected, solution345.reverseVowels(s));
    }

    @Test
    public void example2() {
        String s = "leetcode";
        String expected = "leotcede";
        Assertions.assertEquals(expected, solution345.reverseVowels(s));
    }
}
