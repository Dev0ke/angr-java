import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1305Tests {
    private final Solution1305 solution1305 = new Solution1305();

    @Test
    public void example1() {
        TreeNode root1 = TreeNode.buildTreeNode("[2,1,4]");
        TreeNode root2 = TreeNode.buildTreeNode("[1,0,3]");
        List<Integer> expected = List.of(0, 1, 1, 2, 3, 4);
        Assertions.assertEquals(expected, solution1305.getAllElements(root1, root2));
    }

    @Test
    public void example2() {
        TreeNode root1 = TreeNode.buildTreeNode("[1,null,8]");
        TreeNode root2 = TreeNode.buildTreeNode("[8,1]");
        List<Integer> expected = List.of(1, 1, 8, 8);
        Assertions.assertEquals(expected, solution1305.getAllElements(root1, root2));
    }
}