import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1160Tests {
    private final Solution1160 solution1160 = new Solution1160();

    @Test
    public void example1() {
        String[] words = {"cat", "bt", "hat", "tree"};
        String chars = "atach";
        int expected = 6;
        Assertions.assertEquals(expected, solution1160.countCharacters(words, chars));
    }

    @Test
    public void example2() {
        String[] words = {"hello", "world", "leetcode"};
        String chars = "welldonehoneyr";
        int expected = 10;
        Assertions.assertEquals(expected, solution1160.countCharacters(words, chars));
    }
}