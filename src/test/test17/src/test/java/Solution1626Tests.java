import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1626Tests {
    private final Solution1626 solution1626 = new Solution1626();

    @Test
    public void example1() {
        int[] scores = {1, 3, 5, 10, 15};
        int[] ages = {1, 2, 3, 4, 5};
        int expected = 34;
        Assertions.assertEquals(expected, solution1626.bestTeamScore(scores, ages));
    }

    @Test
    public void example2() {
        int[] scores = {4, 5, 6, 5};
        int[] ages = {2, 1, 2, 1};
        int expected = 16;
        Assertions.assertEquals(expected, solution1626.bestTeamScore(scores, ages));
    }

    @Test
    public void example3() {
        int[] scores = {1, 2, 3, 5};
        int[] ages = {8, 9, 10, 1};
        int expected = 6;
        Assertions.assertEquals(expected, solution1626.bestTeamScore(scores, ages));
    }
}