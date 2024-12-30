import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1778Tests {
    static class GridMasterImpl implements SolutionP1778.GridMaster {
        int m, n, x, y;
        int[][] grid;

        public GridMasterImpl(int[][] grid) {
            this.grid = grid;
            this.m = grid.length;
            this.n = grid[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == -1) {
                        x = i;
                        y = j;
                        return;
                    }
                }
            }
        }

        @Override
        public boolean canMove(char direction) {
            int nx = x, ny = y;
            if (direction == 'U') nx--;
            if (direction == 'D') nx++;
            if (direction == 'L') ny--;
            if (direction == 'R') ny++;
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) return false;
            return grid[nx][ny] != 0;
        }

        @Override
        public void move(char direction) {
            if (canMove(direction)) {
                if (direction == 'U') x--;
                if (direction == 'D') x++;
                if (direction == 'L') y--;
                if (direction == 'R') y++;
            }
        }

        @Override
        public boolean isTarget() {
            return grid[x][y] == 2;
        }
    }

    private final SolutionP1778 solutionP1778 = new SolutionP1778();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,2],[-1,0]]");
        GridMasterImpl gridMaster = new GridMasterImpl(grid);
        int expected = 2;
        Assertions.assertEquals(expected, solutionP1778.findShortestPath(gridMaster));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[0,0,-1],[1,1,1],[2,0,0]]");
        GridMasterImpl gridMaster = new GridMasterImpl(grid);
        int expected = 4;
        Assertions.assertEquals(expected, solutionP1778.findShortestPath(gridMaster));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[-1,0],[0,2]]");
        GridMasterImpl gridMaster = new GridMasterImpl(grid);
        int expected = -1;
        Assertions.assertEquals(expected, solutionP1778.findShortestPath(gridMaster));
    }
}