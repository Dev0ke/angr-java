import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1507Tests {
    private final Solution1507 solution1507 = new Solution1507();

    @Test
    public void example1() {
        String date = "20th Oct 2052";
        String expected = "2052-10-20";
        Assertions.assertEquals(expected, solution1507.reformatDate(date));
    }

    @Test
    public void example2() {
        String date = "6th Jun 1933";
        String expected = "1933-06-06";
        Assertions.assertEquals(expected, solution1507.reformatDate(date));
    }

    @Test
    public void example3() {
        String date = "26th May 1960";
        String expected = "1960-05-26";
        Assertions.assertEquals(expected, solution1507.reformatDate(date));
    }
}