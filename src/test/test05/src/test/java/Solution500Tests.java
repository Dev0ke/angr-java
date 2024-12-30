import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution500Tests {
    private final Solution500 solution500 = new Solution500();

    @Test
    public void example1() {
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        String[] expected = {"Alaska", "Dad"};
        Assertions.assertArrayEquals(expected, solution500.findWords(words));
    }

    @Test
    public void example2() {
        String[] words = {"omk"};
        String[] expected = {};
        Assertions.assertArrayEquals(expected, solution500.findWords(words));
    }

    @Test
    public void example3() {
        String[] words = {"adsdf", "sfd"};
        String[] expected = {"adsdf", "sfd"};
        Assertions.assertArrayEquals(expected, solution500.findWords(words));
    }
}
