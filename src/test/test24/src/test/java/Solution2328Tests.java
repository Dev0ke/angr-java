import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2328Tests {
    private final Solution2328 solution2328 = new Solution2328();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,1],[3,4]]");
        int expected = 8;
        Assertions.assertEquals(expected, solution2328.countPaths(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1],[2]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution2328.countPaths(grid));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/332004472/
        // 不能像 329 题先找最长路径再累加
        int[][] grid = UtUtils.stringToInts2("[[12469,18741,68716,30594,65029,44019,92944,84784,92781,5655,43120,81333,54113,88220,23446,6129,2904,48677,20506,79604,82841,3938,46511,60870,10825,31759,78612,19776,43160,86915,74498,38366,28228,23687,40729,42613,61154,22726,51028,45603,53586,44657,97573,61067,27187,4619,6135,24668,69634,24564,30255,51939,67573,87012,4106,76312,28737,7704,35798]]");
        int expected = 148;
        Assertions.assertEquals(expected, solution2328.countPaths(grid));
    }
}
