import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution389Tests {
    private final Solution389 solution389 = new Solution389();

    @Test
    public void example1() {
        String s = "abcd";
        String t = "abcde";
        char expected = 'e';
        Assertions.assertEquals(expected, solution389.findTheDifference(s, t));
    }

    @Test
    public void example2() {
        String s = "";
        String t = "y";
        char expected = 'y';
        Assertions.assertEquals(expected, solution389.findTheDifference(s, t));
    }
}
