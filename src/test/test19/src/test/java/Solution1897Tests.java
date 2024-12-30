import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1897Tests {
    private final Solution1897 solution1897 = new Solution1897();

    @Test
    public void example1() {
        String[] words = {"abc", "aabc", "bc"};
        Assertions.assertTrue(solution1897.makeEqual(words));
    }

    @Test
    public void example2() {
        String[] words = {"ab", "a"};
        Assertions.assertFalse(solution1897.makeEqual(words));
    }
}
