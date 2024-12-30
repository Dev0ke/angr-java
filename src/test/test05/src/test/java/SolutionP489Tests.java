import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP489Tests {
    static class RobotImpl implements SolutionP489.Robot {
        private final int[][] room;
        private final int M;
        private final int N;
        private int row;
        private int col;
        private int dir = 0;
        private final boolean[][] actual;

        public RobotImpl(int[][] room, int row, int col) {
            this.room = room;
            this.M = room.length;
            this.N = room[0].length;
            this.row = row;
            this.col = col;
            this.actual = new boolean[M][N];
        }

        @Override
        public boolean move() {
            // going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
            if (dir == 0) {
                if (row - 1 >= 0 && room[row - 1][col] == 1) {
                    row--;
                    return true;
                }
            } else if (dir == 1) {
                if (col + 1 < N && room[row][col + 1] == 1) {
                    col++;
                    return true;
                }
            } else if (dir == 2) {
                if (row + 1 < M && room[row + 1][col] == 1) {
                    row++;
                    return true;
                }
            } else {
                if (col - 1 >= 0 && room[row][col - 1] == 1) {
                    col--;
                    return true;
                }
            }
            return false;
        }

        @Override
        public void turnLeft() {
            dir = (dir + 3) % 4;
        }

        @Override
        public void turnRight() {
            dir = (dir + 1) % 4;
        }

        @Override
        public void clean() {
            actual[row][col] = true;
        }
    }

    @Test
    public void example1() {
        int[][] room = {
                {1, 1, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 1, 1, 0, 1, 1},
                {1, 0, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1}
        };
        int row = 1;
        int col = 3;
        // clean 的标记为 true
        boolean[][] expected = {
                {true, true, true, true, true, false, true, true},
                {true, true, true, true, true, false, true, true},
                {true, false, true, true, true, true, true, true},
                {false, false, false, true, false, false, false, false},
                {true, true, true, true, true, true, true, true}
        };
        RobotImpl robot = new RobotImpl(room, row, col);
        SolutionP489 solutionP489 = new SolutionP489();
        solutionP489.cleanRoom(robot);
        Assertions.assertArrayEquals(expected, robot.actual);
    }
}
