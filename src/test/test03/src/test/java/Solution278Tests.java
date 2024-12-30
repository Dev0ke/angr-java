import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution278Tests {
    @Test
    public void example1() {
        int n = 5;
        int bad = 4;
        int expected = 4;
        Assertions.assertEquals(expected, new Solution278.Solution(bad).firstBadVersion(n));
    }

    @Test
    public void example2() {
        int n = 1;
        int bad = 1;
        int expected = 1;
        Assertions.assertEquals(expected, new Solution278.Solution(bad).firstBadVersion(n));
    }

    // 补充用例
    @Test
    public void example3() {
        int n = 2126753390;
        int bad = 1702766719;
        int expected = 1702766719;
        Assertions.assertEquals(expected, new Solution278.Solution(bad).firstBadVersion(n));
    }
}
