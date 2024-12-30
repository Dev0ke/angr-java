import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP742Tests {
    private final SolutionP742 solutionP742 = new SolutionP742();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,3,2]");
        int k = 1;
        // 解释： 2 和 3 都是距离目标 1 最近的叶节点。
//        int expected = 2;
        int expected = 3;
        Assertions.assertEquals(expected, solutionP742.findClosestLeaf(root, k));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1]");
        int k = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solutionP742.findClosestLeaf(root, k));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3,4,null,null,null,5,null,6]");
        int k = 2;
        int expected = 3;
        Assertions.assertEquals(expected, solutionP742.findClosestLeaf(root, k));
    }
}