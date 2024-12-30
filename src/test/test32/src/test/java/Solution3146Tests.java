import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3146Tests {
    private final Solution3146 solution3146 = new Solution3146();

    @Test
    public void example1() {
        String s = "abc";
        String t = "bac";
        int expected = 2;
        Assertions.assertEquals(expected, solution3146.findPermutationDifference(s, t));
    }

    @Test
    public void example2() {
        String s = "abcde";
        String t = "edbac";
        int expected = 12;
        Assertions.assertEquals(expected, solution3146.findPermutationDifference(s, t));
    }
}