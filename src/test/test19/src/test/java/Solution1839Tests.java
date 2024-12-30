import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1839Tests {
    private final Solution1839 solution1839 = new Solution1839();

    @Test
    public void example1() {
        String word = "aeiaaioaaaaeiiiiouuuooaauuaeiu";
        int expected = 13;
        Assertions.assertEquals(expected, solution1839.longestBeautifulSubstring(word));
    }

    @Test
    public void example2() {
        String word = "aeeeiiiioooauuuaeiou";
        int expected = 5;
        Assertions.assertEquals(expected, solution1839.longestBeautifulSubstring(word));
    }

    @Test
    public void example3() {
        String word = "a";
        int expected = 0;
        Assertions.assertEquals(expected, solution1839.longestBeautifulSubstring(word));
    }
}