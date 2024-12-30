import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2840Tests {
    private final Solution2840 solution2840 = new Solution2840();

    @Test
    public void example1() {
        String s1 = "abcdba";
        String s2 = "cabdab";
        Assertions.assertTrue(solution2840.checkStrings(s1, s2));
    }

    @Test
    public void example2() {
        String s1 = "abe";
        String s2 = "bea";
        Assertions.assertFalse(solution2840.checkStrings(s1, s2));
    }
}