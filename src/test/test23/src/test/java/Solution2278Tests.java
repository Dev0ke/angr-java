import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2278Tests {
    private final Solution2278 solution2278 = new Solution2278();

    @Test
    public void example1() {
        String s = "foobar";
        char letter = 'o';
        int expected = 33;
        Assertions.assertEquals(expected, solution2278.percentageLetter(s, letter));
    }

    @Test
    public void example2() {
        String s = "jjjj";
        char letter = 'k';
        int expected = 0;
        Assertions.assertEquals(expected, solution2278.percentageLetter(s, letter));
    }
}
