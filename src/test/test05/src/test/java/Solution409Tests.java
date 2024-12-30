import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution409Tests {
    private final Solution409 solution409 = new Solution409();

    @Test
    public void example1() {
        String s = "abccccdd";
        int expected = 7;
        Assertions.assertEquals(expected, solution409.longestPalindrome(s));
    }
}
