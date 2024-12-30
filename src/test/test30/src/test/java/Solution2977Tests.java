import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2977Tests {
    private final Solution2977 solution2977 = new Solution2977();

    @Test
    public void example1() {
        String source = "abcd";
        String target = "acbe";
        String[] original = {"a", "b", "c", "c", "e", "d"};
        String[] changed = {"b", "c", "b", "e", "b", "e"};
        int[] cost = {2, 5, 5, 1, 2, 20};
        long expected = 28;
        Assertions.assertEquals(expected, solution2977.minimumCost(source, target, original, changed, cost));
    }

    @Test
    public void example2() {
        String source = "abcdefgh";
        String target = "acdeeghh";
        String[] original = {"bcd", "fgh", "thh"};
        String[] changed = {"cde", "thh", "ghh"};
        int[] cost = {1, 3, 5};
        long expected = 9;
        Assertions.assertEquals(expected, solution2977.minimumCost(source, target, original, changed, cost));
    }

    @Test
    public void example3() {
        String source = "abcdefgh";
        String target = "addddddd";
        String[] original = {"bcd", "defgh"};
        String[] changed = {"ddd", "ddddd"};
        int[] cost = {100, 1578};
        long expected = -1;
        Assertions.assertEquals(expected, solution2977.minimumCost(source, target, original, changed, cost));
    }
}