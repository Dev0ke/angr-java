import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1694Tests {
    private final Solution1694 solution1694 = new Solution1694();

    @Test
    public void example1() {
        String number = "1-23-45 6";
        String expected = "123-456";
        Assertions.assertEquals(expected, solution1694.reformatNumber(number));
    }

    @Test
    public void example2() {
        String number = "123 4-567";
        String expected = "123-45-67";
        Assertions.assertEquals(expected, solution1694.reformatNumber(number));
    }

    @Test
    public void example3() {
        String number = "123 4-5678";
        String expected = "123-456-78";
        Assertions.assertEquals(expected, solution1694.reformatNumber(number));
    }

    @Test
    public void example4() {
        String number = "12";
        String expected = "12";
        Assertions.assertEquals(expected, solution1694.reformatNumber(number));
    }

    @Test
    public void example5() {
        String number = "--17-5 229 35-39475 ";
        String expected = "175-229-353-94-75";
        Assertions.assertEquals(expected, solution1694.reformatNumber(number));
    }
}
