import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2410Tests {
    private final Solution2410 solution2410 = new Solution2410();

    @Test
    public void example1() {
        int[] players = {4, 7, 9};
        int[] trainers = {8, 2, 5, 8};
        int expected = 2;
        Assertions.assertEquals(expected, solution2410.matchPlayersAndTrainers(players, trainers));
    }

    @Test
    public void example2() {
        int[] players = {1, 1, 1};
        int[] trainers = {10};
        int expected = 1;
        Assertions.assertEquals(expected, solution2410.matchPlayersAndTrainers(players, trainers));
    }
}
