import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution859Tests {
    private final Solution859 solution859 = new Solution859();

    @Test
    public void example1() {
        String s = "ab";
        String goal = "ba";
        Assertions.assertTrue(solution859.buddyStrings(s, goal));
    }

    @Test
    public void example2() {
        String s = "ab";
        String goal = "ab";
        Assertions.assertFalse(solution859.buddyStrings(s, goal));
    }

    @Test
    public void example3() {
        String s = "aa";
        String goal = "aa";
        Assertions.assertTrue(solution859.buddyStrings(s, goal));
    }

    @Test
    public void example4() {
        String s = "aaaaaaabc";
        String goal = "aaaaaaacb";
        Assertions.assertTrue(solution859.buddyStrings(s, goal));
    }

    @Test
    public void example5() {
        String s = "";
        String goal = "aa";
        Assertions.assertFalse(solution859.buddyStrings(s, goal));
    }
}
