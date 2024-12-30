import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3018Tests {
    private final SolutionP3018 solutionP3018 = new SolutionP3018();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 4, 5};
        int[] queries = {1, 2, 3, 4, 6};
        int expected = 4;
        Assertions.assertEquals(expected, solutionP3018.maximumProcessableQueries(nums, queries));
    }

    @Test
    public void example2() {
        int[] nums = {2, 3, 2};
        int[] queries = {2, 2, 3};
        int expected = 3;
        Assertions.assertEquals(expected, solutionP3018.maximumProcessableQueries(nums, queries));
    }

    @Test
    public void example3() {
        int[] nums = {3, 4, 3};
        int[] queries = {4, 3, 2};
        int expected = 2;
        Assertions.assertEquals(expected, solutionP3018.maximumProcessableQueries(nums, queries));
    }
}