import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3163Tests {
    private final Solution3163 solution3163 = new Solution3163();

    @Test
    public void example1() {
        String word = "abcde";
        String expected = "1a1b1c1d1e";
        Assertions.assertEquals(expected, solution3163.compressedString(word));
    }

    @Test
    public void example2() {
        String word = "aaaaaaaaaaaaaabb";
        String expected = "9a5a2b";
        Assertions.assertEquals(expected, solution3163.compressedString(word));
    }
}