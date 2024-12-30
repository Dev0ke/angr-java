import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionP545Tests {
    private final SolutionP545 solutionP545 = new SolutionP545();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,null,2,3,4]");
        List<Integer> expected = List.of(1, 3, 4, 2);
        Assertions.assertEquals(expected, solutionP545.boundaryOfBinaryTree(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3,4,5,6,null,null,null,7,8,9,10]");
        List<Integer> expected = List.of(1, 2, 4, 7, 8, 9, 10, 6, 3);
        Assertions.assertEquals(expected, solutionP545.boundaryOfBinaryTree(root));
    }
}