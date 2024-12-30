import org.junit.jupiter.api.Test;

public class Solution427Tests {
    private final Solution427 solution427 = new Solution427();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[0,1],[1,0]]");
        // [[0,1],[1,0],[1,1],[1,1],[1,0]]
        solution427.construct(grid);
        // TODO
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,1,1,1,1],[1,1,1,1,1,1,1,1],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0]]");
        // [[0,1],[1,1],[0,1],[1,1],[1,0],null,null,null,null,[1,0],[1,0],[1,1],[1,1]]
        solution427.construct(grid);
        // TODO
    }
}