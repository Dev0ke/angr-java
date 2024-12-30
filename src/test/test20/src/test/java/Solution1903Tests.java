import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1903Tests {
    private final Solution1903 solution1903 = new Solution1903();

    @Test
    public void example1() {
        String num = "52";
        String expected = "5";
        Assertions.assertEquals(expected, solution1903.largestOddNumber(num));
    }

    @Test
    public void example2() {
        String num = "4206";
        String expected = "";
        Assertions.assertEquals(expected, solution1903.largestOddNumber(num));
    }

    @Test
    public void example3() {
        String num = "35427";
        String expected = "35427";
        Assertions.assertEquals(expected, solution1903.largestOddNumber(num));
    }
}
