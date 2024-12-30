import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2060Tests {
    private final Solution2060 solution2060 = new Solution2060();

    @Test
    public void example1() {
        String s1 = "internationalization";
        String s2 = "i18n";
        Assertions.assertTrue(solution2060.possiblyEquals(s1, s2));
    }

    @Test
    public void example2() {
        String s1 = "l123e";
        String s2 = "44";
        Assertions.assertTrue(solution2060.possiblyEquals(s1, s2));
    }

    @Test
    public void example3() {
        String s1 = "a5b";
        String s2 = "c5b";
        Assertions.assertFalse(solution2060.possiblyEquals(s1, s2));
    }

    @Test
    public void example4() {
        String s1 = "112s";
        String s2 = "g841";
        Assertions.assertTrue(solution2060.possiblyEquals(s1, s2));
    }

    @Test
    public void example5() {
        String s1 = "ab";
        String s2 = "a2";
        Assertions.assertFalse(solution2060.possiblyEquals(s1, s2));
    }
}