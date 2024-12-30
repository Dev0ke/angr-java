import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1483Tests {
    @Test
    public void example1() {
        int n = 7;
        int[] parent = {-1, 0, 0, 1, 1, 2, 2};
        Solution1483.TreeAncestor treeAncestor = new Solution1483.TreeAncestor(n, parent);

        // 返回 1 ，它是 3 的父节点
        Assertions.assertEquals(1, treeAncestor.getKthAncestor(3, 1));

        // 返回 0 ，它是 5 的祖父节点
        Assertions.assertEquals(0, treeAncestor.getKthAncestor(5, 2));

        // 返回 -1 因为不存在满足要求的祖先节点
        Assertions.assertEquals(-1, treeAncestor.getKthAncestor(6, 3));
    }

    // 补充用例
    @Test
    public void example2() {
        // https://leetcode.cn/submissions/detail/337725275/
        int n = 2;
        int[] parent = {-1, 0};
        Solution1483.TreeAncestor treeAncestor = new Solution1483.TreeAncestor(n, parent);

        Assertions.assertEquals(-1, treeAncestor.getKthAncestor(1, 2));
    }
}
