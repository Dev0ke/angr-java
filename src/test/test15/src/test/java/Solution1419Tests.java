import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1419Tests {
    private final Solution1419 solution1419 = new Solution1419();

    @Test
    public void example1() {
        String croakOfFrogs = "croakcroak";
        int expected = 1;
        Assertions.assertEquals(expected, solution1419.minNumberOfFrogs(croakOfFrogs));
    }

    @Test
    public void example2() {
        String croakOfFrogs = "crcoakroak";
        int expected = 2;
        Assertions.assertEquals(expected, solution1419.minNumberOfFrogs(croakOfFrogs));
    }

    @Test
    public void example3() {
        String croakOfFrogs = "croakcrook";
        int expected = -1;
        Assertions.assertEquals(expected, solution1419.minNumberOfFrogs(croakOfFrogs));
    }
}
