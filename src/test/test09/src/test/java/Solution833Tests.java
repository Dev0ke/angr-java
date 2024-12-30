import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution833Tests {
    private final Solution833 solution833 = new Solution833();

    @Test
    public void example1() {
        String s = "abcd";
        int[] indices = {0, 2};
        String[] sources = {"a", "cd"};
        String[] targets = {"eee", "ffff"};
        String expected = "eeebffff";
        Assertions.assertEquals(expected, solution833.findReplaceString(s, indices, sources, targets));
    }

    @Test
    public void example2() {
        String s = "abcd";
        int[] indices = {0, 2};
        String[] sources = {"ab", "ec"};
        String[] targets = {"eee", "ffff"};
        String expected = "eeecd";
        Assertions.assertEquals(expected, solution833.findReplaceString(s, indices, sources, targets));
    }
}