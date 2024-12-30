import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1717Tests {
    private final Solution1717 solution1717 = new Solution1717();

    @Test
    public void example1() {
        String s = "cdbcbbaaabab";
        int x = 4;
        int y = 5;
        int expected = 19;
        Assertions.assertEquals(expected, solution1717.maximumGain(s, x, y));
    }

    @Test
    public void example2() {
        String s = "aabbaaxybbaabb";
        int x = 5;
        int y = 4;
        int expected = 20;
        Assertions.assertEquals(expected, solution1717.maximumGain(s, x, y));
    }
}