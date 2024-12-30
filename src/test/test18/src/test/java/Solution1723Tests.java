import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1723Tests {
    private final Solution1723 solution1723 = new Solution1723();

    @Test
    public void example1() {
        int[] jobs = {3, 2, 3};
        int k = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution1723.minimumTimeRequired(jobs, k));
    }

    @Test
    public void example2() {
        int[] jobs = {1, 2, 4, 7, 8};
        int k = 2;
        int expected = 11;
        Assertions.assertEquals(expected, solution1723.minimumTimeRequired(jobs, k));
    }
}
