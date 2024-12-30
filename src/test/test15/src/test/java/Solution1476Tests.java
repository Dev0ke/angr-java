import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1476Tests {
    @Test
    public void example1() {
        int[][] rectangle = UtUtils.stringToInts2("[[1,2,1],[4,3,4],[3,2,1],[1,1,1]]");
        Solution1476.SubrectangleQueries subrectangleQueries = new Solution1476.SubrectangleQueries(rectangle);
        // 初始的 (4x3) 矩形如下：
        // 1 2 1
        // 4 3 4
        // 3 2 1
        // 1 1 1

        // 返回 1
        Assertions.assertEquals(1, subrectangleQueries.getValue(0, 2));
        subrectangleQueries.updateSubrectangle(0, 0, 3, 2, 5);
        // 此次更新后矩形变为：
        // 5 5 5
        // 5 5 5
        // 5 5 5
        // 5 5 5

        // 返回 5
        Assertions.assertEquals(5, subrectangleQueries.getValue(0, 2));

        // 返回 5
        Assertions.assertEquals(5, subrectangleQueries.getValue(3, 1));
        subrectangleQueries.updateSubrectangle(3, 0, 3, 2, 10);
        // 此次更新后矩形变为：
        // 5   5   5
        // 5   5   5
        // 5   5   5
        // 10  10  10

        // 返回 10
        Assertions.assertEquals(10, subrectangleQueries.getValue(3, 1));

        // 返回 5
        Assertions.assertEquals(5, subrectangleQueries.getValue(0, 2));
    }

    @Test
    public void example2() {
        int[][] rectangle = UtUtils.stringToInts2("[[1,1,1],[2,2,2],[3,3,3]]");
        Solution1476.SubrectangleQueries2 subrectangleQueries = new Solution1476.SubrectangleQueries2(rectangle);

        // 返回 1
        Assertions.assertEquals(1, subrectangleQueries.getValue(0, 0));
        subrectangleQueries.updateSubrectangle(0, 0, 2, 2, 100);

        // 返回 100
        Assertions.assertEquals(100, subrectangleQueries.getValue(0, 0));

        // 返回 100
        Assertions.assertEquals(100, subrectangleQueries.getValue(2, 2));
        subrectangleQueries.updateSubrectangle(1, 1, 2, 2, 20);

        // 返回 20
        Assertions.assertEquals(20, subrectangleQueries.getValue(2, 2));
    }
}