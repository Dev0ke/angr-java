import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1641Tests {
    private final Solution1641 solution1641 = new Solution1641();

    @Test
    public void example1() {
        int n = 1;
        int expected = 5;
        Assertions.assertEquals(expected, solution1641.countVowelStrings(n));
    }

    @Test
    public void example2() {
        int n = 2;
        int expected = 15;
        Assertions.assertEquals(expected, solution1641.countVowelStrings(n));
    }

    @Test
    public void example3() {
        int n = 33;
        int expected = 66045;
        Assertions.assertEquals(expected, solution1641.countVowelStrings(n));
    }
}
