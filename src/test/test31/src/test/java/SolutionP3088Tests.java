import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3088Tests {
    private final SolutionP3088 solutionP3088 = new SolutionP3088();

    @Test
    public void example1() {
        String s = "abca";
        String expected = "aabc";
        Assertions.assertEquals(expected, solutionP3088.makeAntiPalindrome(s));
    }

    @Test
    public void example2() {
        String s = "abba";
        String expected = "aabb";
        Assertions.assertEquals(expected, solutionP3088.makeAntiPalindrome(s));
    }

    @Test
    public void example3() {
        String s = "cccd";
        String expected = "-1";
        Assertions.assertEquals(expected, solutionP3088.makeAntiPalindrome(s));
    }
}