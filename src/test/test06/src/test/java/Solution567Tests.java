import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution567Tests {
    private final Solution567 solution567 = new Solution567();

    @Test
    public void example1() {
        String s1 = "ab";
        String s2 = "eidbaooo";
        Assertions.assertTrue(solution567.checkInclusion(s1, s2));
    }

    @Test
    public void example2() {
        String s1 = "ab";
        String s2 = "eidboaoo";
        Assertions.assertFalse(solution567.checkInclusion(s1, s2));
    }
}
