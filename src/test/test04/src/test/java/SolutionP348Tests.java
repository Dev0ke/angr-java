import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP348Tests {
    @Test
    public void example1() {
        SolutionP348.TicTacToe toe = new SolutionP348.TicTacToe(3);
        
        // 玩家 1 在 (0, 0) 落子。
        // 函数返回 0 (此时，暂时没有玩家赢得这场对决)
        Assertions.assertEquals(0, toe.move(0, 0, 1));

        // 玩家 2 在 (0, 2) 落子。
        // 函数返回 0 (暂时没有玩家赢得本场比赛)
        Assertions.assertEquals(0, toe.move(0, 2, 2));

        // 玩家 1 在 (2, 2) 落子。
        // 函数返回 0 (暂时没有玩家赢得比赛)
        Assertions.assertEquals(0, toe.move(2, 2, 1));

        // 玩家 2 在 (1, 1) 落子。
        // 函数返回 0 (暂没有玩家赢得比赛)
        Assertions.assertEquals(0, toe.move(1, 1, 2));

        // 玩家 1 在 (2, 0) 落子。
        // 函数返回 0 (暂无玩家赢得比赛)
        Assertions.assertEquals(0, toe.move(2, 0, 1));

        // 玩家 2 在 (1, 0) 落子.
        // 函数返回 0 (没有玩家赢得比赛)
        Assertions.assertEquals(0, toe.move(1, 0, 2));

        // 玩家 1 在 (2, 1) 落子。
        // 函数返回 1 (此时，玩家 1 赢得了该场比赛)
        Assertions.assertEquals(1, toe.move(2, 1, 1));
    }
}
