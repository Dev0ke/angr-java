import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution655Tests {
    private final Solution655 solution655 = new Solution655();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,2]");
        List<List<String>> expected = UtUtils.stringToStringList2("""
                [["","1",""],
                 ["2","",""]]
                """);
        Assertions.assertEquals(expected, solution655.printTree(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3,null,4]");
        List<List<String>> expected = UtUtils.stringToStringList2("""
                [["","","","1","","",""],
                 ["","2","","","","3",""],
                 ["","","4","","","",""]]
                """);
        Assertions.assertEquals(expected, solution655.printTree(root));
    }
}