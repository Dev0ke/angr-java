import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2678Tests {
    private final Solution2678 solution2678 = new Solution2678();

    @Test
    public void example1() {
        String[] details = {"7868190130M7522", "5303914400F9211", "9273338290F4010"};
        int expected = 2;
        Assertions.assertEquals(expected, solution2678.countSeniors(details));
    }

    @Test
    public void example2() {
        String[] details = {"1313579440F2036", "2921522980M5644"};
        int expected = 0;
        Assertions.assertEquals(expected, solution2678.countSeniors(details));
    }
}