import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution242Tests {
    private final Solution242 solution242 = new Solution242();

    @Test
    public void example1() {
        String s = "anagram";
        String t = "nagaram";
        Assertions.assertTrue(solution242.isAnagram(s, t));
    }

    @Test
    public void example2() {
        String s = "rat";
        String t = "car";
        Assertions.assertFalse(solution242.isAnagram(s, t));
    }
}
