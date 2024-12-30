import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2013Tests {
    @Test
    public void example1() {
        Solution2013.DetectSquares detectSquares = new Solution2013.DetectSquares();
        detectSquares.add(new int[]{3, 10});
        detectSquares.add(new int[]{11, 2});
        detectSquares.add(new int[]{3, 2});
        // 返回 1 。你可以选择：
        Assertions.assertEquals(1, detectSquares.count(new int[]{11, 10}));
        //   - 第一个，第二个，和第三个点

        // 返回 0 。查询点无法与数据结构中的这些点构成正方形。
        Assertions.assertEquals(0, detectSquares.count(new int[]{14, 8}));

        // 允许添加重复的点。
        detectSquares.add(new int[]{11, 2});

        // 返回 2 。你可以选择：
        Assertions.assertEquals(2, detectSquares.count(new int[]{11, 10}));
        //   - 第一个，第二个，和第三个点
        //   - 第一个，第三个，和第四个点
    }
}
