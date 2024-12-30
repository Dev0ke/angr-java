import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution564Tests {
    private final Solution564 solution564 = new Solution564();

    @Test
    public void example1() {
        String n = "123";
        String expected = "121";
        Assertions.assertEquals(expected, solution564.nearestPalindromic(n));
    }

    @Test
    public void example2() {
        String n = "1";
        String expected = "0";
        Assertions.assertEquals(expected, solution564.nearestPalindromic(n));
    }
}