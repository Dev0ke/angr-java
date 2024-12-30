import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution113Tests {
    private final Solution113 solution113 = new Solution113();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[5,4,8,11,null,13,4,7,2,null,null,5,1]");
        int targetSum = 22;
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[5,4,11,2],[5,8,4,5]]");
        Assertions.assertEquals(expected, solution113.pathSum(root, targetSum));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3]");
        int targetSum = 5;
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[]");
        Assertions.assertEquals(expected, solution113.pathSum(root, targetSum));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[1,2]");
        int targetSum = 0;
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[]");
        Assertions.assertEquals(expected, solution113.pathSum(root, targetSum));
    }
}
