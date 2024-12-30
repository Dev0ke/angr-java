import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution893Tests {
    private final Solution893 solution893 = new Solution893();

    @Test
    public void example1() {
        String[] words = {"abcd", "cdab", "cbad", "xyzz", "zzxy", "zzyx"};
        int expected = 3;
        Assertions.assertEquals(expected, solution893.numSpecialEquivGroups(words));
    }

    @Test
    public void example2() {
        String[] words = {"abc", "acb", "bac", "bca", "cab", "cba"};
        int expected = 3;
        Assertions.assertEquals(expected, solution893.numSpecialEquivGroups(words));
    }
}
