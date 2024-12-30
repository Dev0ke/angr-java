import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution97Tests {
    private final Solution97 solution97 = new Solution97();

    @Test
    public void example1() {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        Assertions.assertTrue(solution97.isInterleave(s1, s2, s3));
    }

    @Test
    public void example2() {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc";
        Assertions.assertFalse(solution97.isInterleave(s1, s2, s3));
    }

    @Test
    public void example3() {
        String s1 = "", s2 = "", s3 = "";
        Assertions.assertTrue(solution97.isInterleave(s1, s2, s3));
    }
}
