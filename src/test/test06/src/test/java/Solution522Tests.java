import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution522Tests {
    private final Solution522 solution522 = new Solution522();

    @Test
    public void example1() {
        String[] strs = {"aba", "cdc", "eae"};
        int expected = 3;
        Assertions.assertEquals(expected, solution522.findLUSlength(strs));
    }

    @Test
    public void example2() {
        String[] strs = {"aaa", "aaa", "aa"};
        int expected = -1;
        Assertions.assertEquals(expected, solution522.findLUSlength(strs));
    }
}
