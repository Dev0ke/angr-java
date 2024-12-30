import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution443Tests {
    private final Solution443 solution443 = new Solution443();

    @Test
    public void example1() {
        char[] chars = UtUtils.stringToChars("""
                ["a","a","b","b","c","c","c"]
                """);
        int expected = 6;
        Assertions.assertEquals(expected, solution443.compress(chars));
    }

    @Test
    public void example2() {
        char[] chars = UtUtils.stringToChars("""
                ["a"]
                """);
        int expected = 1;
        Assertions.assertEquals(expected, solution443.compress(chars));
    }

    @Test
    public void example3() {
        char[] chars = UtUtils.stringToChars("""
                ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
                """);
        int expected = 4;
        Assertions.assertEquals(expected, solution443.compress(chars));
    }
}
