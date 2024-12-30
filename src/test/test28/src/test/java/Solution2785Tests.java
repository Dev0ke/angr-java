import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2785Tests {
    private final Solution2785 solution2785 = new Solution2785();

    @Test
    public void example1() {
        String s = "lEetcOde";
        String expected = "lEOtcede";
        Assertions.assertEquals(expected, solution2785.sortVowels(s));
    }

    @Test
    public void example2() {
        String s = "lYmpH";
        String expected = "lYmpH";
        Assertions.assertEquals(expected, solution2785.sortVowels(s));
    }
}