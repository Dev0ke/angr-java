import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP1810Tests {
    static class GridMasterImpl implements SolutionP1810.GridMaster {
        int m, n, x, y, r2, c2;
        int[][] grid;

        public GridMasterImpl(int[][] grid, int r1, int c1, int r2, int c2) {
            this.grid = grid;
            this.m = grid.length;
            this.n = grid[0].length;
            x = r1;
            y = c1;
            this.r2 = r2;
            this.c2 = c2;
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
        public int move(char direction) {
            if (canMove(direction)) {
                if (direction == 'U') x--;
                if (direction == 'D') x++;
                if (direction == 'L') y--;
                if (direction == 'R') y++;
                return grid[x][y];
            }
            return -1;
        }

        @Override
        public boolean isTarget() {
            return x == r2 && y == c2;
        }
    }

    private final SolutionP1810 solutionP1810 = new SolutionP1810();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[2,3],[1,1]]");
        int r1 = 0, c1 = 1, r2 = 1, c2 = 0;
        GridMasterImpl gridMaster = new GridMasterImpl(grid, r1, c1, r2, c2);
        int expected = 2;
        Assertions.assertEquals(expected, solutionP1810.findShortestPath(gridMaster));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[0,3,1],[3,4,2],[1,2,0]]");
        int r1 = 2, c1 = 0, r2 = 0, c2 = 2;
        GridMasterImpl gridMaster = new GridMasterImpl(grid, r1, c1, r2, c2);
        int expected = 9;
        Assertions.assertEquals(expected, solutionP1810.findShortestPath(gridMaster));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[1,0],[0,1]]");
        int r1 = 0, c1 = 0, r2 = 1, c2 = 1;
        GridMasterImpl gridMaster = new GridMasterImpl(grid, r1, c1, r2, c2);
        int expected = -1;
        Assertions.assertEquals(expected, solutionP1810.findShortestPath(gridMaster));
    }
}