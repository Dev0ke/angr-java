import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2451Tests {
    private final Solution2451 solution2451 = new Solution2451();

    @Test
    public void example1() {
        String[] words = {"adc", "wzy", "abc"};
        String expected = "abc";
        Assertions.assertEquals(expected, solution2451.oddString(words));
    }

    @Test
    public void example2() {
        String[] words = {"aaa", "bob", "ccc", "ddd"};
        String expected = "bob";
        Assertions.assertEquals(expected, solution2451.oddString(words));
    }
}
