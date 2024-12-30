import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution953Tests {
    private final Solution953 solution953 = new Solution953();

    @Test
    public void example1() {
        String[] words = {"hello", "leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        Assertions.assertTrue(solution953.isAlienSorted(words, order));
    }

    @Test
    public void example2() {
        String[] words = {"word", "world", "row"};
        String order = "worldabcefghijkmnpqstuvxyz";
        Assertions.assertFalse(solution953.isAlienSorted(words, order));
    }

    @Test
    public void example3() {
        String[] words = {"apple", "app"};
        String order = "abcdefghijklmnopqrstuvwxyz";
        Assertions.assertFalse(solution953.isAlienSorted(words, order));
    }
}
