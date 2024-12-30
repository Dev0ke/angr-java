import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2911Tests {
    private final Solution2911 solution2911 = new Solution2911();

    @Test
    public void example1() {
        String s = "abcac";
        int k = 2;
        int expected = 1;
        Assertions.assertEquals(expected, solution2911.minimumChanges(s, k));
    }

    @Test
    public void example2() {
        String s = "abcdef";
        int k = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution2911.minimumChanges(s, k));
    }

    @Test
    public void example3() {
        String s = "aabbaa";
        int k = 3;
        int expected = 0;
        Assertions.assertEquals(expected, solution2911.minimumChanges(s, k));
    }
}