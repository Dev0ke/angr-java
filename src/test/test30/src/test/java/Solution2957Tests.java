import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2957Tests {
    private final Solution2957 solution2957 = new Solution2957();

    @Test
    public void example1() {
        String word = "aaaaa";
        int expected = 2;
        Assertions.assertEquals(expected, solution2957.removeAlmostEqualCharacters(word));
    }

    @Test
    public void example2() {
        String word = "abddez";
        int expected = 2;
        Assertions.assertEquals(expected, solution2957.removeAlmostEqualCharacters(word));
    }

    @Test
    public void example3() {
        String word = "zyxyxyz";
        int expected = 3;
        Assertions.assertEquals(expected, solution2957.removeAlmostEqualCharacters(word));
    }
}