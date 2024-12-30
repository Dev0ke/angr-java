import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3223Tests {
    private final Solution3223 solution3223 = new Solution3223();

    @Test
    public void example1() {
        String s = "abaacbcbb";
        int expected = 5;
        Assertions.assertEquals(expected, solution3223.minimumLength(s));
    }

    @Test
    public void example2() {
        String s = "aa";
        int expected = 2;
        Assertions.assertEquals(expected, solution3223.minimumLength(s));
    }
}