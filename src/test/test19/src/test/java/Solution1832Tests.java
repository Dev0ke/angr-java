import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1832Tests {
    private final Solution1832 solution1832 = new Solution1832();

    @Test
    public void example1() {
        String sentence = "thequickbrownfoxjumpsoverthelazydog";
        Assertions.assertTrue(solution1832.checkIfPangram(sentence));
    }

    @Test
    public void example2() {
        String sentence = "leetcode";
        Assertions.assertFalse(solution1832.checkIfPangram(sentence));
    }
}
