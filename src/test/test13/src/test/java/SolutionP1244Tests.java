import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1244Tests {
    @Test
    public void example1() {
        SolutionP1244.Leaderboard leaderboard = new SolutionP1244.Leaderboard();

        // leaderboard = [[1,73]];
        leaderboard.addScore(1, 73);

        // leaderboard = [[1,73],[2,56]];
        leaderboard.addScore(2, 56);

        // leaderboard = [[1,73],[2,56],[3,39]];
        leaderboard.addScore(3, 39);

        // leaderboard = [[1,73],[2,56],[3,39],[4,51]];
        leaderboard.addScore(4, 51);

        // leaderboard = [[1,73],[2,56],[3,39],[4,51],[5,4]];
        leaderboard.addScore(5, 4);

        // returns 73;
        Assertions.assertEquals(73, leaderboard.top(1));

        // leaderboard = [[2,56],[3,39],[4,51],[5,4]];
        leaderboard.reset(1);

        // leaderboard = [[3,39],[4,51],[5,4]];
        leaderboard.reset(2);

        // leaderboard = [[2,51],[3,39],[4,51],[5,4]];
        leaderboard.addScore(2, 51);

        // returns 141 = 51 + 51 + 39;
        Assertions.assertEquals(141, leaderboard.top(3));
    }
}
