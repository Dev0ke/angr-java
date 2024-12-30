import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution987Tests {
    private final Solution987 solution987 = new Solution987();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[3,9,20,null,null,15,7]");
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[9],[3,15],[20],[7]]");
        Assertions.assertEquals(expected, solution987.verticalTraversal(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3,4,5,6,7]");
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[4],[2],[1,5,6],[3],[7]]");
        Assertions.assertEquals(expected, solution987.verticalTraversal(root));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3,4,6,5,7]");
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[4],[2],[1,5,6],[3],[7]]");
        Assertions.assertEquals(expected, solution987.verticalTraversal(root));
    }
}