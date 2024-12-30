import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3016Tests {
    private final Solution3016 solution3016 = new Solution3016();

    @Test
    public void example1() {
        String word = "abcde";
        int expected = 5;
        Assertions.assertEquals(expected, solution3016.minimumPushes(word));
    }

    @Test
    public void example2() {
        String word = "xyzxyzxyzxyz";
        int expected = 12;
        Assertions.assertEquals(expected, solution3016.minimumPushes(word));
    }

    @Test
    public void example3() {
        String word = "aabbccddeeffgghhiiiiii";
        int expected = 24;
        Assertions.assertEquals(expected, solution3016.minimumPushes(word));
    }
}