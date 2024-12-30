import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution943Tests {
    private final Solution943 solution943 = new Solution943();

    @Test
    public void example1() {
        String[] words = {"alex", "loves", "leetcode"};
        String expected = "alexlovesleetcode";
        Assertions.assertEquals(expected, solution943.shortestSuperstring(words));
    }

    @Test
    public void example2() {
        String[] words = {"catg", "ctaagt", "gcta", "ttca", "atgcatc"};
        String expected = "gctaagttcatgcatc";
        Assertions.assertEquals(expected, solution943.shortestSuperstring(words));
    }
}