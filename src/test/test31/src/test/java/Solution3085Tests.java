import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3085Tests {
    private final Solution3085 solution3085 = new Solution3085();

    @Test
    public void example1() {
        String word = "aabcaba";
        int k = 0;
        int expected = 3;
        Assertions.assertEquals(expected, solution3085.minimumDeletions(word, k));
    }

    @Test
    public void example2() {
        String word = "dabdcbdcdcd";
        int k = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution3085.minimumDeletions(word, k));
    }

    @Test
    public void example3() {
        String word = "aaabaaa";
        int k = 2;
        int expected = 1;
        Assertions.assertEquals(expected, solution3085.minimumDeletions(word, k));
    }
}