import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3076Tests {
    private final Solution3076 solution3076 = new Solution3076();

    @Test
    public void example1() {
        String[] arr = {"cab", "ad", "bad", "c"};
        String[] expected = {"ab", "", "ba", ""};
        Assertions.assertArrayEquals(expected, solution3076.shortestSubstrings(arr));
    }

    @Test
    public void example2() {
        String[] arr = {"abc", "bcd", "abcd"};
        String[] expected = {"", "", "abcd"};
        Assertions.assertArrayEquals(expected, solution3076.shortestSubstrings(arr));
    }
}