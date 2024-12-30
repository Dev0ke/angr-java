import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1071Tests {
    private final Solution1071 solution1071 = new Solution1071();

    @Test
    public void example1() {
        String str1 = "ABCABC";
        String str2 = "ABC";
        String expected = "ABC";
        Assertions.assertEquals(expected, solution1071.gcdOfStrings(str1, str2));
    }

    @Test
    public void example2() {
        String str1 = "ABABAB";
        String str2 = "ABAB";
        String expected = "AB";
        Assertions.assertEquals(expected, solution1071.gcdOfStrings(str1, str2));
    }

    @Test
    public void example3() {
        String str1 = "LEET";
        String str2 = "CODE";
        String expected = "";
        Assertions.assertEquals(expected, solution1071.gcdOfStrings(str1, str2));
    }
}