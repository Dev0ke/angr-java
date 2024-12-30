import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1684Tests {
    private final Solution1684 solution1684 = new Solution1684();

    @Test
    public void example1() {
        String allowed = "ab";
        String[] words = {"ad", "bd", "aaab", "baa", "badab"};
        int expected = 2;
        Assertions.assertEquals(expected, solution1684.countConsistentStrings(allowed, words));
    }

    @Test
    public void example2() {
        String allowed = "abc";
        String[] words = {"a", "b", "c", "ab", "ac", "bc", "abc"};
        int expected = 7;
        Assertions.assertEquals(expected, solution1684.countConsistentStrings(allowed, words));
    }

    @Test
    public void example3() {
        String allowed = "cad";
        String[] words = {"cc", "acd", "b", "ba", "bac", "bad", "ac", "d"};
        int expected = 4;
        Assertions.assertEquals(expected, solution1684.countConsistentStrings(allowed, words));
    }
}
