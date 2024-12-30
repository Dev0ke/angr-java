import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2019Tests {
    private final Solution2019 solution2019 = new Solution2019();

    @Test
    public void example1() {
        String s = "7+3*1*2";
        int[] answers = {20, 13, 42};
        int expected = 7;
        Assertions.assertEquals(expected, solution2019.scoreOfStudents(s, answers));
    }

    @Test
    public void example2() {
        String s = "3+5*2";
        int[] answers = {13, 0, 10, 13, 13, 16, 16};
        int expected = 19;
        Assertions.assertEquals(expected, solution2019.scoreOfStudents(s, answers));
    }

    @Test
    public void example3() {
        String s = "6+0*1";
        int[] answers = {12, 9, 6, 4, 8, 6};
        int expected = 10;
        Assertions.assertEquals(expected, solution2019.scoreOfStudents(s, answers));
    }
}