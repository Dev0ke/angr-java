import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution1110Tests {
    private final Solution1110 solution1110 = new Solution1110();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3,4,5,6,7]");
        int[] to_delete = {3, 5};
        List<TreeNode> expected = Arrays.asList(TreeNode.buildTreeNode("[1,2,null,4]"), TreeNode.buildTreeNode("[6]"), TreeNode.buildTreeNode("[7]"));
        List<TreeNode> actual = solution1110.delNodes(root, to_delete);
        expected.sort(Comparator.comparingInt(o -> o.val));
        actual.sort(Comparator.comparingInt(o -> o.val));
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, actual));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,4,null,3]");
        int[] to_delete = {3};
        List<TreeNode> expected = Arrays.asList(TreeNode.buildTreeNode("[1,2,4]"));
        List<TreeNode> actual = solution1110.delNodes(root, to_delete);
        expected.sort(Comparator.comparingInt(o -> o.val));
        actual.sort(Comparator.comparingInt(o -> o.val));
        Assertions.assertTrue(UtUtils.assertJsonEquals(expected, actual));
    }
}