import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution2512Tests {
    private final Solution2512 solution2512 = new Solution2512();

    @Test
    public void example1() {
        String[] positive_feedback = {"smart", "brilliant", "studious"};
        String[] negative_feedback = {"not"};
        String[] report = {"this student is studious", "the student is smart"};
        int[] student_id = {1, 2};
        int k = 2;
        List<Integer> expected = List.of(1, 2);
        Assertions.assertEquals(expected, solution2512.topStudents(positive_feedback, negative_feedback, report, student_id, k));
    }

    @Test
    public void example2() {
        String[] positive_feedback = {"smart", "brilliant", "studious"};
        String[] negative_feedback = {"not"};
        String[] report = {"this student is not studious", "the student is smart"};
        int[] student_id = {1, 2};
        int k = 2;
        List<Integer> expected = List.of(2, 1);
        Assertions.assertEquals(expected, solution2512.topStudents(positive_feedback, negative_feedback, report, student_id, k));
    }
}
