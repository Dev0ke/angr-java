import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution839Tests {
    private final Solution839 solution839 = new Solution839();

    @Test
    public void example1() {
        String[] strs = {"tars", "rats", "arts", "star"};
        int expected = 2;
        Assertions.assertEquals(expected, solution839.numSimilarGroups(strs));
    }

    @Test
    public void example2() {
        String[] strs = {"omv", "ovm"};
        int expected = 1;
        Assertions.assertEquals(expected, solution839.numSimilarGroups(strs));
    }
}
