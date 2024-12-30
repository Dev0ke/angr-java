import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1700Tests {
    private final Solution1700 solution1700 = new Solution1700();

    @Test
    public void example1() {
        int[] students = {1, 1, 0, 0};
        int[] sandwiches = {0, 1, 0, 1};
        int expected = 0;
        Assertions.assertEquals(expected, solution1700.countStudents(students, sandwiches));
    }

    @Test
    public void example2() {
        int[] students = {1, 1, 1, 0, 0, 1};
        int[] sandwiches = {1, 0, 0, 0, 1, 1};
        int expected = 3;
        Assertions.assertEquals(expected, solution1700.countStudents(students, sandwiches));
    }
}
