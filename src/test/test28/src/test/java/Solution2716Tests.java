import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2716Tests {
    private final Solution2716 solution2716 = new Solution2716();

    @Test
    public void example1() {
        String s = "aaabc";
        int expected = 3;
        Assertions.assertEquals(expected, solution2716.minimizedStringLength(s));
    }

    @Test
    public void example2() {
        String s = "cbbd";
        int expected = 3;
        Assertions.assertEquals(expected, solution2716.minimizedStringLength(s));
    }

    @Test
    public void example3() {
        String s = "dddaaa";
        int expected = 2;
        Assertions.assertEquals(expected, solution2716.minimizedStringLength(s));
    }
}