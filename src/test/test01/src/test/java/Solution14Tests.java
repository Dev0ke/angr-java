import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution14Tests {
    private final Solution14 solution14 = new Solution14();

    @Test
    public void example1() {
        String[] strs = {"flower", "flow", "flight"};
        String expected = "fl";
        Assertions.assertEquals(expected, solution14.longestCommonPrefix(strs));
    }

    @Test
    public void example2() {
        String[] strs = {"dog", "racecar", "car"};
        String expected = "";
        Assertions.assertEquals(expected, solution14.longestCommonPrefix(strs));
    }
}
