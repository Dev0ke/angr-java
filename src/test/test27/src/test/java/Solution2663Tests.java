import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2663Tests {
    private final Solution2663 solution2663 = new Solution2663();

    @Test
    public void example1() {
        String s = "abcz";
        int k = 26;
        String expected = "abda";
        Assertions.assertEquals(expected, solution2663.smallestBeautifulString(s, k));
    }

    @Test
    public void example2() {
        String s = "dc";
        int k = 4;
        String expected = "";
        Assertions.assertEquals(expected, solution2663.smallestBeautifulString(s, k));
    }
}