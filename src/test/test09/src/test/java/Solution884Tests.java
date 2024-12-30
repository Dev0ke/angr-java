import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution884Tests {
    private final Solution884 solution884 = new Solution884();

    @Test
    public void example1() {
        String s1 = "this apple is sweet";
        String s2 = "this apple is sour";
        String[] expected = {"sweet", "sour"};
        Assertions.assertArrayEquals(expected, solution884.uncommonFromSentences(s1, s2));
    }

    @Test
    public void example2() {
        String s1 = "apple apple";
        String s2 = "banana";
        String[] expected = {"banana"};
        Assertions.assertArrayEquals(expected, solution884.uncommonFromSentences(s1, s2));
    }
}
