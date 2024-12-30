import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution383Tests {
    private final Solution383 solution383 = new Solution383();

    @Test
    public void example1() {
        String ransomNote = "a";
        String magazine = "b";
        Assertions.assertFalse(solution383.canConstruct(ransomNote, magazine));
    }

    @Test
    public void example2() {
        String ransomNote = "aa";
        String magazine = "ab";
        Assertions.assertFalse(solution383.canConstruct(ransomNote, magazine));
    }

    @Test
    public void example3() {
        String ransomNote = "aa";
        String magazine = "aab";
        Assertions.assertTrue(solution383.canConstruct(ransomNote, magazine));
    }
}
