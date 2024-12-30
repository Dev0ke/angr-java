import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2063Tests {
    private final Solution2063 solution2063 = new Solution2063();

    @Test
    public void example1() {
        String word = "aba";
        long expected = 6;
        Assertions.assertEquals(expected, solution2063.countVowels(word));
    }

    @Test
    public void example2() {
        String word = "abc";
        long expected = 3;
        Assertions.assertEquals(expected, solution2063.countVowels(word));
    }

    @Test
    public void example3() {
        String word = "ltcd";
        long expected = 0;
        Assertions.assertEquals(expected, solution2063.countVowels(word));
    }

    @Test
    public void example4() {
        String word = "noosabasboosa";
        long expected = 237;
        Assertions.assertEquals(expected, solution2063.countVowels(word));
    }

    // 补充用例
    @Test
    public void example5() {
        String word = UtUtils.loadingString("solution2063-example5-input.txt", 0);
        long expected = 32003263569662L;
        Assertions.assertEquals(expected, solution2063.countVowels(word));
    }
}
