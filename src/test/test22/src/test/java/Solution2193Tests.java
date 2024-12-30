import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2193Tests {
    private final Solution2193 solution2193 = new Solution2193();

    @Test
    public void example1() {
        String s = "aabb";
        int expected = 2;
        Assertions.assertEquals(expected, solution2193.minMovesToMakePalindrome(s));
    }

    @Test
    public void example2() {
        String s = "letelt";
        int expected = 2;
        Assertions.assertEquals(expected, solution2193.minMovesToMakePalindrome(s));
    }

    // 补充用例
    @Test
    public void example3() {
        String s = "eqvvhtcsaaqtqesvvqch";
        int expected = 17;
        Assertions.assertEquals(expected, solution2193.minMovesToMakePalindrome(s));
    }

    @Test
    public void example4() {
        String s = "skwhhaaunskegmdtutlgtteunmuuludii";
        int expected = 163;
        Assertions.assertEquals(expected, solution2193.minMovesToMakePalindrome(s));
    }
}
