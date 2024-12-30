import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2976Tests {
    private final Solution2976 solution2976 = new Solution2976();

    @Test
    public void example1() {
        String source = "abcd";
        String target = "acbe";
        char[] original = UtUtils.stringToChars("""
                ["a","b","c","c","e","d"]
                """);
        char[] changed = UtUtils.stringToChars("""
                ["b","c","b","e","b","e"]
                """);
        int[] cost = {2, 5, 5, 1, 2, 20};
        long expected = 28;
        Assertions.assertEquals(expected, solution2976.minimumCost(source, target, original, changed, cost));
    }

    @Test
    public void example2() {
        String source = "aaaa";
        String target = "bbbb";
        char[] original = UtUtils.stringToChars("""
                ["a","c"]
                """);
        char[] changed = UtUtils.stringToChars("""
                ["c","b"]
                """);
        int[] cost = {1, 2};
        long expected = 12;
        Assertions.assertEquals(expected, solution2976.minimumCost(source, target, original, changed, cost));
    }

    @Test
    public void example3() {
        String source = "abcd";
        String target = "abce";
        char[] original = UtUtils.stringToChars("""
                ["a"]
                """);
        char[] changed = UtUtils.stringToChars("""
                ["e"]
                """);
        int[] cost = {10000};
        long expected = -1;
        Assertions.assertEquals(expected, solution2976.minimumCost(source, target, original, changed, cost));
    }
}