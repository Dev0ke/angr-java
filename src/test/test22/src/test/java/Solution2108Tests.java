import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2108Tests {
    private final Solution2108 solution2108 = new Solution2108();

    @Test
    public void example1() {
        String[] words = {"abc", "car", "ada", "racecar", "cool"};
        String expected = "ada";
        Assertions.assertEquals(expected, solution2108.firstPalindrome(words));
    }

    @Test
    public void example2() {
        String[] words = {"notapalindrome", "racecar"};
        String expected = "racecar";
        Assertions.assertEquals(expected, solution2108.firstPalindrome(words));
    }

    @Test
    public void example3() {
        String[] words = {"def", "ghi"};
        String expected = "";
        Assertions.assertEquals(expected, solution2108.firstPalindrome(words));
    }
}
