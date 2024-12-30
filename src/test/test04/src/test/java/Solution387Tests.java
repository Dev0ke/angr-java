import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution387Tests {
    private final Solution387 solution387 = new Solution387();

    @Test
    public void example1() {
        String s = "leetcode";
        int expected = 0;
        Assertions.assertEquals(expected, solution387.firstUniqChar(s));
    }

    @Test
    public void example2() {
        String s = "loveleetcode";
        int expected = 2;
        Assertions.assertEquals(expected, solution387.firstUniqChar(s));
    }
}
