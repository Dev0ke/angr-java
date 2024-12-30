import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2516Tests {
    private final Solution2516 solution2516 = new Solution2516();

    @Test
    public void example1() {
        String s = "aabaaaacaabc";
        int k = 2;
        int expected = 8;
        Assertions.assertEquals(expected, solution2516.takeCharacters(s, k));
    }

    @Test
    public void example2() {
        String s = "a";
        int k = 1;
        int expected = -1;
        Assertions.assertEquals(expected, solution2516.takeCharacters(s, k));
    }
}
