import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionP1274Tests {
    static class SeaImpl implements SolutionP1274.Sea {
        int[][] ps2d;

        public SeaImpl(int[][] ships) {
            int[][] grid = new int[1005][1005];
            for (int[] ship : ships) {
                int x = ship[0], y = ship[1];
                grid[x][y] = 1;
            }
            int m = grid.length;
            int n = grid[0].length;

            ps2d = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    ps2d[i][j] = ps2d[i - 1][j] + ps2d[i][j - 1] - ps2d[i - 1][j - 1] + grid[i - 1][j - 1];
                }
            }
        }

        @Override
        public boolean hasShips(int[] topRight, int[] bottomLeft) {
            int x1 = bottomLeft[0];
            int y1 = bottomLeft[1];
            int x2 = topRight[0];
            int y2 = topRight[1];
            return ps2d[x2 + 1][y2 + 1] - ps2d[x2 + 1][y1] - ps2d[x1][y2 + 1] + ps2d[x1][y1] > 0;
        }
    }

    private final SolutionP1274 solutionP1274 = new SolutionP1274();

    @Test
    public void example1() {
        int[][] ships = UtUtils.stringToInts2("[[1,1],[2,2],[3,3],[5,5]]");
        SeaImpl sea = new SeaImpl(ships);
        int[] topRight = {4, 4};
        int[] bottomLeft = {0, 0};
        int expected = 3;
        Assertions.assertEquals(expected, solutionP1274.countShips(sea, topRight, bottomLeft));
    }

    @Test
    public void example2() {
        int[][] ships = UtUtils.stringToInts2("[[1,1],[2,2],[3,3]]");
        SeaImpl sea = new SeaImpl(ships);
        int[] topRight = {1000, 1000};
        int[] bottomLeft = {0, 0};
        int expected = 3;
        Assertions.assertEquals(expected, solutionP1274.countShips(sea, topRight, bottomLeft));
    }
}