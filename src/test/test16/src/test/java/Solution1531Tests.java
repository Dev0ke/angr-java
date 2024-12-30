import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1531Tests {
    private final Solution1531 solution1531 = new Solution1531();

    @Test
    public void example1() {
        String s = "aaabcccd";
        int k = 2;
        int expected = 4;
        Assertions.assertEquals(expected, solution1531.getLengthOfOptimalCompression(s, k));
    }

    @Test
    public void example2() {
        String s = "aabbaa";
        int k = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution1531.getLengthOfOptimalCompression(s, k));
    }

    @Test
    public void example3() {
        String s = "aaaaaaaaaaa";
        int k = 0;
        int expected = 3;
        Assertions.assertEquals(expected, solution1531.getLengthOfOptimalCompression(s, k));
    }
}