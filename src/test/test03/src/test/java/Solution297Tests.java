import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution297Tests {
    private final Solution297.Codec codec = new Solution297.Codec();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3,null,null,4,5]");
        String serializeStr = codec.serialize(root);
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(root, codec.deserialize(serializeStr)));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[]");
        String serializeStr = codec.serialize(root);
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(root, codec.deserialize(serializeStr)));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[1]");
        String serializeStr = codec.serialize(root);
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(root, codec.deserialize(serializeStr)));
    }

    @Test
    public void example4() {
        TreeNode root = TreeNode.buildTreeNode("[1,2]");
        String serializeStr = codec.serialize(root);
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(root, codec.deserialize(serializeStr)));
    }
}
