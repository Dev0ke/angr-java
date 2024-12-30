import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1941Tests {
    private final Solution1941 solution1941 = new Solution1941();

    @Test
    public void example1() {
        String s = "abacbc";
        Assertions.assertTrue(solution1941.areOccurrencesEqual(s));
    }

    @Test
    public void example2() {
        String s = "aaabb";
        Assertions.assertFalse(solution1941.areOccurrencesEqual(s));
    }
}
