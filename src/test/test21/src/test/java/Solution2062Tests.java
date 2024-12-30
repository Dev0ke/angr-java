import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2062Tests {
    private final Solution2062 solution2062 = new Solution2062();

    @Test
    public void example1() {
        String word = "aeiouu";
        int expected = 2;
        Assertions.assertEquals(expected, solution2062.countVowelSubstrings(word));
    }

    @Test
    public void example2() {
        String word = "unicornarihan";
        int expected = 0;
        Assertions.assertEquals(expected, solution2062.countVowelSubstrings(word));
    }

    @Test
    public void example3() {
        String word = "cuaieuouac";
        int expected = 7;
        Assertions.assertEquals(expected, solution2062.countVowelSubstrings(word));
    }

    @Test
    public void example4() {
        String word = "bbaeixoubb";
        int expected = 0;
        Assertions.assertEquals(expected, solution2062.countVowelSubstrings(word));
    }
}
